package TronGame.Tron.Controllers;

import TronGame.Tron.Repositories.Repository;
import TronGame.Tron.Entities.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping(path="/demo")
public class UserController {

    @Autowired
    private Repository Repository;

    @GetMapping(path="/add") // Map ONLY GET Requests
    public @ResponseBody String addNewUser(@RequestParam String username, @RequestParam String name,
                                           @RequestParam String email, @RequestParam String password) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User user = new User();
        user.setUsername(username);
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setRegistration(new Date());
        Repository.save(user);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return Repository.findAll();
    }
}