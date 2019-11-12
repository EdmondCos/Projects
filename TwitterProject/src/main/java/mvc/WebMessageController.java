package mvc;

import entities.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import services.MessageService;

import java.time.LocalDateTime;

@Controller
@RequestMapping(value = "")
public class WebMessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping(value = "save-message")
    public ModelAndView saveMessage(ModelAndView model, @ModelAttribute Message message) {
        message.setDateTime(LocalDateTime.now());
        System.out.println(message.getText() + "\n" + message.getId() + "\n" + message.getDateTime());
        messageService.saveMessage(message);

        model.addObject("message", message.getText());
        model.addObject("date", LocalDateTime.now().toString());
        model.setViewName("userHome");
        return model;
    }

}
