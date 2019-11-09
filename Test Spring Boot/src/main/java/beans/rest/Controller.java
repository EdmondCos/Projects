package beans.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class Controller {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Ion", "pass"));
        users.add(new User(2, "Popescu", "altPass"));
        return users;
    }
}
