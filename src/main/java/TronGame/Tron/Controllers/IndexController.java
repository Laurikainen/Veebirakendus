package TronGame.Tron.Controllers;


    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.RequestMapping;

@Controller
    public class IndexController {

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("text", "Welcome to Tron Online");
        return "index";
    }

    @RequestMapping("/book/{id}")
    public String getBootById(Model model, @PathVariable("id") Long id){
        model.addAttribute("bookId", id);
        return "book";
    }

}
