package mvc;

import entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import services.AccountService;
import services.MessageService;

@Controller
@RequestMapping(value = "")
public class WebAccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping(value = "")
    public ModelAndView loginPage(ModelAndView model) {
        model.setViewName("loginPage");
        return model;
    }

    @GetMapping({"home"})
    public ModelAndView homePage(ModelAndView model) {
        model.setViewName("userHome");

        for (Account account : accountService.getAllAccounts()) {
            System.out.println(account.getMessages().get(0).getText());
            System.out.println(account.getMessages().get(0).getUsername());
            System.out.println(account.getMessages().get(0).getPosting());
        }

        return model;
    }

    @PostMapping(value = "/login-form")
    public ModelAndView loginForm(ModelAndView model, @ModelAttribute Account account) {
        System.out.println("test " + account.getEmail() + " " + account.getPassword());
        Account existing = accountService.findAccountByEmail(account.getEmail());

        if (existing != null) {
            if (accountService.validPassord(account, existing)) {
                System.out.println("correct data");
                model.addObject("name", existing.getUsername());
                model.setViewName("userHome");
                return model;
            } else {
                System.out.println("bad credentials");
                model.addObject("wrongCredentials", "Email or password is incorrect.");
                model.setViewName("loginPage");
                return model;
            }

        } else {
            System.out.println("no account");
            model.addObject("noAccount", "No account with this email exists");
            model.setViewName("loginPage");
            return model;
        }
    }

    @GetMapping(value = "/register")
    public ModelAndView newAccount(ModelAndView model) {
        model.setViewName("register");
        return model;
    }

    @PostMapping(value = "/save-account")
    public ModelAndView saveAccount(ModelAndView model, @ModelAttribute Account account) {
        Account newAccount = accountService.findAccountByEmail(account.getEmail());

        if (newAccount != null) {
            model.addObject("alreadyRegisteredMessage", "There is already a user registered with the email provided.");
            model.setViewName("register");
            return model;
        }

        if (!accountService.canSaveNewAccount(account)) {
            model.addObject("existingUserEmail", "Username is already in use.");
            model.setViewName("register");
            return model;
        } else {
            model.addObject("okMessage", "Account has been created!");
            model.addObject("name", account.getUsername());
            model.setViewName("userHome");
            return model;
        }
    }


    @DeleteMapping(value = "/delete")
    public ModelAndView deleteAccount(ModelAndView model, @RequestParam("email") String email) {
        accountService.delete(email);
        model.setViewName("userHome");
        return model;
    }

//    TODO:print messages according to results
//    TODO:lock pages behind loginPage/access
//    TODO:edit and delete account from userpage

}
