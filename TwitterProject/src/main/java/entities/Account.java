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
@EqualsAndHashCode(of = {"email"})
public class Account {

    @Id
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    private String password;

    @Column(unique = true)
    private String username;


}
