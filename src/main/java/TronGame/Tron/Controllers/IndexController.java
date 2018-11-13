package TronGame.Tron.Controllers;

import TronGame.Tron.Entities.SendEmail;
import TronGame.Tron.Entities.StatisticsForm;
import TronGame.Tron.Repositories.RegistrationRepository;
import TronGame.Tron.Repositories.StatisticsRepository;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@EnableScheduling
    public class IndexController {
    private double manifestID = Math.random();


    //This checks for an update every 5 minutes for the cache
    @Scheduled(fixedDelay=300000)
    public void NewManifestID() {
        manifestID = Math.random();
    }

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
    public String forum(){
        return "forum";
    }

    @RequestMapping("/new_post")
    public String new_post(){ return "new_post"; }

    @RequestMapping("/privacy_policy")
    public String privacy_policy(){ return "privacy_policy"; }

    @RequestMapping("/about_us")
    public String about_us(){ return "map"; }

    @RequestMapping("/sitemap")
    public String sitemap(){ return "sitemap"; }

    @RequestMapping("/updates")
    public String updateCheck(Model model) {
        System.out.println(model.asMap());
        System.out.println(model.asMap().get(0));

        model.asMap().get(0);
        while(true) {
            boolean thereIsUpdates = false;


            if( thereIsUpdates ) {
                break;
            }
        }
        return "someResponse";
    }



//    @RequestMapping("/updateId")
//    public String updateId(Model model) {
//        return Double.toString(updateID);
//    }

    @RequestMapping("/userFallback")
    public String user_fallback(){ return "userFallback"; }

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

    @RequestMapping(value = "offline.appcache", method = RequestMethod.GET, produces = "text/cache-manifest")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String manifestUnlogged() {
        String text = "";


        if (SecurityContextHolder.getContext().getAuthentication() != null &&
            SecurityContextHolder.getContext().getAuthentication().isAuthenticated() &&
            //when Anonymous Authentication is enabled
            !(SecurityContextHolder.getContext().getAuthentication()
                    instanceof AnonymousAuthenticationToken)) {
            text =  "CACHE MANIFEST\n" +
                    "#v3 - 19.10.2018 (logged in)\n" +
                    "#Randomly generated manifest ID: " + Double.toString(manifestID).substring(2) + "\n" +
                    //"/\n" +
                    "static/css/stiil.css\n" +
                    //"/privacy_policy\n" +
                    //"/play_game\n" +
                    "/userFallback\n" +
                    "static/js/map.js\n" +
                    "static/js/jquery-1.7.1.js\n" +
                    "static/js/offline.js\n" +
                    //"/about_us\n" +
                    //"/upload\n" +
                    "\n" +
                    "FALLBACK:\n" +
                    "/ userFallback\n" +
                    "\n" +
                    "NETWORK:\n" +
                    "*";
    }
    else {
        text = "CACHE MANIFEST\n" +
                "#v3 - 19.10.2018 (logged out)\n" +
                "#Randomly generated manifest ID: " + Double.toString(manifestID).substring(2) + "\n" +
                //"/\n" +
                "static/css/stiil.css\n" +
                //"/privacy_policy\n" +
                //"/play_game\n" +
                "/userFallback\n" +
                "static/js/map.js\n" +
                "static/js/offline.js\n" +
                "static/js/jquery-1.7.1.js\n" +
                //"/about_us\n" +
                "\n" +
                "FALLBACK:\n" +
                "/ /userFallback\n" +
                "\n" +
                "NETWORK:\n" +
                "*";
    }

    return text;
    }

    @RequestMapping("/googlee5541141b" + "a3fb51d.html")
    public String googlee5541141ba3fb51d(){ return "googlee5541141ba3fb51d.html"; }





}
