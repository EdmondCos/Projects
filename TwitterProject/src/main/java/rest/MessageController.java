package rest;

import entities.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.MessageService;

import java.util.List;

@RestController
@RequestMapping(value = "/mess")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

}
