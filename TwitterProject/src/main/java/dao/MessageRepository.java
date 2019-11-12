package dao;

import entities.Message;
import org.springframework.data.repository.CrudRepository;


public interface MessageRepository extends CrudRepository<Message, String> {
    Message findByText(String text);
}
