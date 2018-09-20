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

    @RequestMapping("/forum")
    public String forum(){ return "forum"; }

    @RequestMapping("/play_game")
    public String play_game(){ return "play_game"; }

    @RequestMapping("/registration")
    public String registration(){ return "registration"; }

    @RequestMapping("/new_post")
    public String new_post(){ return "new_post"; }


}
