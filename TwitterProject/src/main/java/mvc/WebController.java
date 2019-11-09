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
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
//        RestTemplate restTemplate = new RestTemplate();
//        String fooResourceUrl = "http://localhost:8080/twitter/account/all";
//        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl + "/1", String.class);


        HttpURLConnection connection = null;
        try {

            {
                URL url = new URL("http://localhost:8080/twitter/account/all");
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
            }

            String content;

            {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder stringBuilder = new StringBuilder();
                while ((inputLine = reader.readLine()) != null) {
                    stringBuilder.append(inputLine);
                }
                reader.close();
                content = stringBuilder.toString();
            }
            return new HashSet<>(Arrays.asList(new ObjectMapper().readValue(content, Account[].class)));

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            connection.disconnect();
        }
    }
}
