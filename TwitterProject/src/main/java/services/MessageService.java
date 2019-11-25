package services;

import dao.AccountRepository;
import dao.MessageRepository;
import entities.Account;
import entities.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private AccountRepository accountRepository;

    public void saveMessage(Message message) {
        message.defineDate();

        Account user = accountRepository.findByUsername(message.getUsername());
        List<Message> messages = user.getMessages();
        messages.add(message);
        user.setMessages(messages);

        messageRepository.save(message);
    }

    public ModelAndView getMessagesOfUser(ModelAndView model, String username) {
        List<Message> userMessages = getAllMessagesReversed();
        List<Message> toKeep = new LinkedList<>();
        Account account = accountRepository.findByUsername(username);

        for (Message message : userMessages) {
            Account messageOwner = accountRepository.findByUsername(message.getUsername());
            if (username.equals(message.getUsername()) || account.getFollowers().contains(messageOwner)) {
                toKeep.add(message);
            }
        }

        model.addObject("messages", toKeep);
        model.addObject("name", username);
        model.setViewName("userHome");
        return model;
    }


    private List<Message> getAllMessagesReversed() {
        List<Message> temp = (List<Message>) messageRepository.findAll();

        List<Message> messages = new LinkedList<>();
        for (int i = temp.size() - 1; i >= 0; i--) {
            messages.add(temp.get(i));
        }
        return messages;
    }


}

