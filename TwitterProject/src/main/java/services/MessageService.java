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
        List<Message> toRemove = new LinkedList<>();

        for (Message message : userMessages) {
            if (!message.getUsername().equals(username)) {
                toRemove.add(message);
            }
        }
        userMessages.removeAll(toRemove);

        System.out.println(username);
        System.out.println(userMessages);
        model.addObject("messages", userMessages);
        model.addObject("name", username);
        model.setViewName("userHome");
        return model;
    }

    public void deleteMessage(Message message) {
        messageRepository.delete(message);
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

