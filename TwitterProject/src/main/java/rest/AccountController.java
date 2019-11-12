package rest;

import entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.AccountService;

import java.util.Set;

@RestController
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Set<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

}
