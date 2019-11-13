package mvc;

import dao.AccountRepository;
import entities.Account;
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
    private AccountRepository accountRepository;

    @PostMapping(value = "save-message")
    public ModelAndView saveMessage(ModelAndView model, @ModelAttribute Message message) {
        System.out.println(message.getText() + " " + message.getId() + " " + message.getPosting());

        Account account = accountRepository.findByUsername(message.getPosting());

        message.setPosting(LocalDateTime.now());
        message.setAccount(account);
        messageService.saveMessage(message);

        model.setViewName("userHome");
        return model;
    }

}
