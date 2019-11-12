package dao;

import entities.Message;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;

public interface MessageRepository extends CrudRepository<Message, Long> {
    Message findByDate(LocalDateTime dateTime);

    Message findByText(String text);
}
