package TronGame.Tron.Controllers;

import TronGame.Tron.Entities.RegistrationForm;
import TronGame.Tron.Entities.StatisticsForm;
import TronGame.Tron.Repositories.RegistrationRepository;
import TronGame.Tron.Repositories.StatisticsRepository;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Map;

@Controller
    public class IndexController {

    @Autowired
    private StatisticsRepository statisticsRepository;

    @Autowired
    private RegistrationRepository registrationRepository;

    @RequestMapping("/")
    public String main_page(HttpServletRequest request){

        String userAgentString = request.getHeader("User-Agent");
        UserAgent userAgent = UserAgent.parseUserAgentString(userAgentString);
        OperatingSystem os = userAgent.getOperatingSystem();
        Browser browser = userAgent.getBrowser();
        int id = userAgent.getId();

        StatisticsForm statisticsForm = new StatisticsForm();
        statisticsForm.setOs(os.toString());
        statisticsForm.setBrowser(browser.toString());
        statisticsForm.setUser_id(id);

        statisticsRepository.save(statisticsForm);

        return "main_page";
    }

    @RequestMapping("/login")
    public String login(){ return "login"; }

    @RequestMapping("/forum")
    public String forum(){ return "forum"; }

    @RequestMapping("/play_game")
    public String play_game(){ return "play_game"; }

    @RequestMapping("/new_post")
    public String new_post(){ return "new_post"; }

    @RequestMapping("/privacy_policy")
    public String privacy_policy(){ return "privacy_policy"; }

    @RequestMapping("/about_us")
    public String about_us(){ return "map"; }

    @RequestMapping("/statistics")
    public String statistics(Model model){
        model.addAttribute("browsers", statisticsRepository.browsers());
        model.addAttribute("browsers_count", statisticsRepository.browsers_count());
        model.addAttribute("os", statisticsRepository.os());
        model.addAttribute("os_count", statisticsRepository.os_count());
        model.addAttribute("id", statisticsRepository.id());
        model.addAttribute("id_count", statisticsRepository.id_count());
        return "statistics";
    }

    @RequestMapping("/googlee5541141b" + "a3fb51d.html")
    public String googlee5541141ba3fb51d(){ return "googlee5541141ba3fb51d.html"; }
}
