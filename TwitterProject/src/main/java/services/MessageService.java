package services;

import dao.MessageRepository;
import entities.Account;
import entities.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;


    public void saveMessage(Message message) {
        messageRepository.save(message);
    }

    public void deleteMessage(Message message) {
        messageRepository.delete(message);
    }


    public List<Message> getAllMessages() {
        List<Message> messages = new ArrayList<>();
        for (Message message : messageRepository.findAll()) {
            messages.add(message);
        }
        return messages;
    }

}

