package entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "messages")
@EqualsAndHashCode(exclude = "account")
@ToString(exclude = "account")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_gen")
    @SequenceGenerator(name = "message_gen", sequenceName = "message_seq", allocationSize = 1)
    @Column(name = "id")
    private long id;

    @Column(name = "message")
    private String text;

    @Column(name = "postdate")
    private String posting;

    @ManyToOne
    @JoinColumn(name = "username")
    private Account account;


    public void defineDate() {
        String dateTime = LocalDateTime.now().toString();
        dateTime = dateTime.replace("T", " ").substring(0, dateTime.length() - 7);

        this.posting = dateTime;
    }

}
