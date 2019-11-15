package services;

import dao.MessageRepository;
import entities.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ConcurrentModificationException;
import java.util.LinkedList;
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
        List<Message> messages = new LinkedList<>();
        for (Message message : messageRepository.findAll()) {
            messages.add(message);
        }
        return messages;
    }

    public List<Message> getMessagesOfUser(String username) {
        List<Message> userMessages = getAllMessages();

        try {
            for (Message message : userMessages) {
                if (!message.getUsername().equals(username)) {
                    userMessages.remove(message);
                }
            }
        } catch (ConcurrentModificationException e) {
            return new LinkedList<>();
        }

        return userMessages;
    }


}

