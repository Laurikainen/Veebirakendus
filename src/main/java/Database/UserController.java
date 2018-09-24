package Database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Database.User;
import Database.Repository;

@Controller
@RequestMapping(path="/demo")
    public class UserController {
        @Autowired
        private Repository Repository;

        @GetMapping(path="/add") // Map ONLY GET Requests
        public @ResponseBody String addNewUser (@RequestParam String name
                , @RequestParam String email) {
            // @ResponseBody means the returned String is the response, not a view name
            // @RequestParam means it is a parameter from the GET or POST request

            User n = new User();
            n.setName(name);
            n.setEmail(email);
            Repository.save(n);
            return "Saved";
        }

        @GetMapping(path="/all")
        public @ResponseBody Iterable<User> getAllUsers() {
            // This returns a JSON or XML with the users
            return Repository.findAll();
        }
    }