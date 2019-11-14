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
import services.AccountService;
import services.MessageService;

@Controller
@RequestMapping(value = "")
public class WebMessageController {

    @Autowired
    private MessageService messageService;
    @Autowired
    private AccountService accountService;

    @PostMapping(value = "save-message")
    public ModelAndView saveMessage(ModelAndView model, @ModelAttribute Message message) {
        Account account = accountService.findAccountByUsername(message.getPosting());
        System.out.println(account.getUsername() + " " + account.getEmail() + " " + account.getPassword());
        message.setAccount(account);

        message.defineDate();
        messageService.saveMessage(message);

        model.setViewName("userHome");
        return model;
    }

}
