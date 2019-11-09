package entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "account")
@EqualsAndHashCode(of = {"username"})
public class Account {

    @Id
    @Column(name = "username")
    private String username;

    private String password;

    @Column(unique = true, nullable = false)
    private String email;

}
