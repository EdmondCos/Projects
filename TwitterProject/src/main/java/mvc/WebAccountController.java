package mvc;

import entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import services.AccountService;

@Controller
@RequestMapping(value = "")
public class WebAccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping({""})
    public String loginPage(Model model) {
        return "login";
    }

    @GetMapping(value = "/login")
    public String login(ModelAndView modelAndView, @ModelAttribute Account account) {
        System.out.println("test " + account.getEmail() + " " + account.getPassword());
        if (accountService.existsAccount(account)) {
            System.out.println("correct data");
            return "userHome";
        } else {
            System.out.println("bad credentials");
            modelAndView.addObject("wrongCredentials", "Email or password is incorrect.");
            return "login";
        }
    }

    @GetMapping(value = "/register")
    public String newAccount(Model model) {
        return "register";
    }

    @GetMapping(value = "/save-account")
    public String saveAccount(ModelAndView modelAndView, @ModelAttribute Account account) {
        Account newAccount = accountService.findByEmail(account.getEmail());

        if (newAccount != null) {
            modelAndView.addObject("alreadyRegisteredMessage", "There is already a user registered with the email provided.");
            return "register";
        }

        if (!accountService.canSaveNewAccount(account)) {
            modelAndView.addObject
                    ("existingUserEmail", "Username is already in use.");
            return "register";
        } else {
            modelAndView.addObject("okMessage", "Account has been created!");
            return "userHome";
        }
    }

    @GetMapping({"home"})
    public String homePage(Model model) {
        return "userHome";
    }

    @GetMapping(value = "/delete")
    public String deleteAccount(Model model, @RequestParam("username") String username) {
        accountService.delete(username);
        return "userHome";
    }

//    TODO:print messages according to results
//    TODO:lock pages behind login/access
//    TODO:edit and delete account from userpage

}
