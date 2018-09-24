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

    @RequestMapping("/privacy_policy")
    public String privacy_policy(){ return "privacy_policy"; }


    @RequestMapping("/googlee5541141b" +
            "a3fb51d.html")
    public String googlee5541141ba3fb51d(){ return "googlee5541141ba3fb51d.html"; }
}
