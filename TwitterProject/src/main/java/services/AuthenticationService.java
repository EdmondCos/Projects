package services;

import dao.AccountRepository;
import entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import static org.springframework.security.web.context.HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY;

@Service
public class AuthenticationService {

    @Autowired
    private MessageService messageService;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    public ModelAndView register(ModelAndView model, Account account) {
        String attributeValue = isValidForRegistration(account);
        if (attributeValue.equals("")) {
            account.setPassword(passwordEncoder.encode(account.getPassword()));
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
//            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(account.getEmail(), account.getPassword());
//            Authentication authentication = authenticationManager.authenticate(token);
//            SecurityContext context = SecurityContextHolder.getContext();
//            context.setAuthentication(authentication);
//
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
        //Checks received password equals with stored one ---- must add password encoder
        else if (!account.getPassword().equals(existing.getPassword())) {
            return "Password is incorrect.";
        }
        return "";
    }


    public void delete(String email) {
        accountRepository.deleteById(email);
    }

    public Set<Account> getAllAccounts() {
        Set<Account> results = new HashSet<>();
        for (Account account : accountRepository.findAll()) {
            results.add(account);
        }
        return results;
    }

//    TODO: add edit user page
//    TODO: add delete button
}
