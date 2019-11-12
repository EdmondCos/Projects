package entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_gen")
    @SequenceGenerator(name = "message_gen", sequenceName = "message_seq", allocationSize = 1)
    @Column(name = "id")
    private long id;

    @Column(name = "message")
    private String text;

    @Column(name = "postdate")
    private String dateTime;

    @ManyToOne
    @JoinColumn(name = "username")
    private Account account;

    public void setDateTime(LocalDateTime date) {
        String dateTime = date.toString();
        dateTime = dateTime.replace("T", " ").substring(0, dateTime.length() - 7);

        this.dateTime = dateTime;
    }
}
