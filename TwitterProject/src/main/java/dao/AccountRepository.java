package dao;

import entities.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, String> {
    Account findByEmail(String email);
    Account findByUsername (String username);
}
