package TronGame.Tron.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
    public class IndexController {

    @RequestMapping("/")
    public String main_page(){
        return "main_page";
    }

    @RequestMapping("/user")
    public String user(){
        return "user";
    }

    @RequestMapping("/login")
    public String login(){ return "login"; }

    /*@RequestMapping("/forum")
    public String forum(Model model){
        return "book";
    }

    @RequestMapping("/user")
    public String user(Model model){
        return "book";
    }*/


}
