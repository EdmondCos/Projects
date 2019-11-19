package services;

import dao.AccountRepository;
import entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;


@Service
public class AuthenticationService {

    @Autowired
    private MessageService messageService;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

//    @Autowired
//    private AuthenticationManager authenticationManager;


    public ModelAndView register(ModelAndView model, Account account) {
        String attributeValue = isValidForRegistration(account);
        if (attributeValue.equals("")) {
//            must add passwordEncoder.encode()
            account.setPassword(account.getPassword());
            account.setMessages(new LinkedList<>());
            accountRepository.save(account);
            model.addObject("name", account.getUsername());
            model.addObject("okMessage", "Account has been created!");
            return messageService.getMessagesOfUser(model, account.getUsername());
        }

        model.addObject("dataAlreadyRegistered", attributeValue);
        model.setViewName("register");
        return model;
    }

    public ModelAndView login(ModelAndView model, HttpServletRequest request, Account account) {
        String attributeValue = isValidLogin(account);

        if (attributeValue.equals("")) {

//            UsernamePasswordAuthenticationToken createToken = new UsernamePasswordAuthenticationToken(account.getEmail(), account.getPassword());
//            Authentication authentication = authenticationManager.authenticate(createToken);
//            SecurityContext context = SecurityContextHolder.getContext();
//            context.setAuthentication(authentication);
//            HttpSession sesssion = request.getSession(true);
//            sesssion.setAttribute(SPRING_SECURITY_CONTEXT_KEY, context);

            String username = accountRepository.findByEmail(account.getEmail()).getUsername();
            model.addObject("name", username);
            return messageService.getMessagesOfUser(model, username);
        }

        model.addObject("wrongCredentials", attributeValue);
        model.setViewName("loginPage");
        return model;
    }

    private String isValidForRegistration(Account account) {
        // Checks if provided email is already in use
        Account existingAccount = accountRepository.findByEmail(account.getEmail());
        if (existingAccount != null) {
            return "Email is already registered.";
        }
        // Checks if provided username is already in use
        existingAccount = accountRepository.findByUsername(account.getUsername());
        if (existingAccount != null) {
            return "Username is already in use.";
        }
        return "";
    }

    private String isValidLogin(Account account) throws UsernameNotFoundException {
        //Checks is account exists in db
        Account existing = accountRepository.findByEmail(account.getEmail());
        if (existing == null) {
            return "Email is incorrect.";
        }
        //Checks received password equals with stored one ---- must add passwordEncoder.encode()
        else if (!account.getPassword().equals(existing.getPassword())) {
            return "Password is incorrect.";
        }
        return "";
    }

}
