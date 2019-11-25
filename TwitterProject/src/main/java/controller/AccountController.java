package controller;

import entities.Account;
import entities.Follower;
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
        model = authenticationService.login(model, request, account);
        return model;
    }


    @PostMapping("/search")
    public ModelAndView searchAccounts(ModelAndView model, String username, String keyword) {
        model = accountService.searchAccounts(model, username, keyword);
        return model;
    }

    @PostMapping("/following")
    public ModelAndView updateFollowers(@ModelAttribute Follower follower, ModelAndView model, String username) {
        model = accountService.updateFollowers(model, username, follower);
        return model;
    }
}
