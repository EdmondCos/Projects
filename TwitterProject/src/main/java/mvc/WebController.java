package mvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import services.AccountService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

@Controller
@RequestMapping(value = "/mvc")
public class WebController {

    @Autowired
    AccountService accountService;

    @GetMapping({"/all"})
    public String getAccounts(Model model) {
        model.addAttribute("accounts", getAccountsFromExternalSources());
        return "html";
    }

    @GetMapping(value = "/delete")
    public String deleteAccount(Model model, @RequestParam("username") String username) {
        accountService.delete(username);
        model.addAttribute("accounts", getAccountsFromExternalSources());
        return "html";
    }

    private Set<Account> getAccountsFromExternalSources() {
        RestTemplate connection = new RestTemplate();
        String url = "http://localhost:8080/twitter/account/all";
        ResponseEntity<Account[]> response = connection.getForEntity(url, Account[].class);

        HashSet<Account> accounts = new HashSet<>();
        Collections.addAll(accounts, Objects.requireNonNull(response.getBody()));

        return accounts;
    }
}
