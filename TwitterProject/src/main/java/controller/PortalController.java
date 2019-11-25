package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "")
public class PortalController {

    @GetMapping(value = "")
    public ModelAndView loginPage(ModelAndView model) {
        model.setViewName("loginPage");
        return model;
    }

    @GetMapping(value = "/register")
    public ModelAndView register(ModelAndView model) {
        model.setViewName("register");
        return model;
    }

    @GetMapping({"/home"})
    public ModelAndView homepage(ModelAndView model) {
        model.setViewName("userHome");
        return model;
    }
}
