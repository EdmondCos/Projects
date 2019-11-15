package entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "accounts")
@EqualsAndHashCode(exclude = "messages")
@ToString(exclude = "messages")
public class Account {

    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String username;

    @OneToMany
    private List<Message> messages;


}
