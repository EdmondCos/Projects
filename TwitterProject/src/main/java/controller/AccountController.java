package controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import services.AccountService;
import services.AuthenticationService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("")
public class AccountController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private AccountService accountService;

    @PostMapping("/register-account")
    public ModelAndView registerAccount(ModelAndView model, @ModelAttribute Account account) {
        model = authenticationService.register(model, account);
        return model;
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute Account account, HttpServletRequest request, ModelAndView model) {
        System.out.println(account.getEmail());
        model = authenticationService.login(model, request, account);
        return model;
    }

    @DeleteMapping("/delete")
    public ModelAndView deleteAccount(ModelAndView model) {
        model.setViewName("loginPage");
        return model;
    }

    @PostMapping("/search")
    public ModelAndView searchAccounts(ModelAndView model, String username, String keyword) {
        System.out.println("User: " + username + " Keyword: " + keyword);
        model = accountService.searchAccounts(model, username, keyword);
        return model;
    }


//    TODO:lock pages behind loginPage/access
//    TODO:edit user details
//    TODO:delete account

}
