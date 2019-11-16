package controller;


import entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import services.AuthenticationService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("")
public class AccountController {

    @Autowired
    private AuthenticationService authenticationService;

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

    //    @DeleteMapping(value = "/delete")
//    public ModelAndView deleteAccount(ModelAndView model, @RequestParam("email") String email) {
//        accountService.delete(email);
//        model.setViewName("userHome");
//        return model;
//    }
//
////    TODO:lock pages behind loginPage/access
////    TODO:edit user details
////    TODO:delete account
//

}
