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
    AccountService accountService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Set<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Account getAccount(@RequestParam(name = "email") String email) {
        return accountService.getAccount(email);
    }

//    @PostMapping(value = "", consumes = "application/js", produces = "application/js")
//    public Account createAccount(@RequestBody Account account) {
//        return accountService.saveNewAccount(account);
//    }

    @DeleteMapping(value = "")
    public void deleteAccount(@RequestParam("email") String email) {
        accountService.delete(email);
    }

}
