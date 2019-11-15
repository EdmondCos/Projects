package mvc;

import entities.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import services.AccountService;
import services.MessageService;

@Controller
@RequestMapping(value = "")
public class WebMessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping(value = "save-message")
    public ModelAndView saveMessage(ModelAndView model, @ModelAttribute Message message) {
        message.defineDate();
        messageService.saveMessage(message);

        model.setViewName("userHome");
        return model;
    }

}
