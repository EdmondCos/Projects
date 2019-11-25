package controller;

import entities.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import services.MessageService;

@Controller
@RequestMapping(value = "")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping(value = "save-message")
    public ModelAndView saveMessage(ModelAndView model, @ModelAttribute Message message) {
        messageService.saveMessage(message);
        model = messageService.getMessagesOfUser(model, message.getUsername());

        return model;
    }
}
