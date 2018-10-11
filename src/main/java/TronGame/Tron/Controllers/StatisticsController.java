package TronGame.Tron.Controllers;

import TronGame.Tron.Entities.StatisticsForm;
import TronGame.Tron.Repositories.StatisticsRepository;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class StatisticsController {

    @Autowired
    private StatisticsRepository statisticsRepository;

    @RequestMapping ("/statistics")
    public String statistics(HttpServletRequest request){
        String userAgentString = request.getHeader("User-Agent");
        UserAgent userAgent = UserAgent.parseUserAgentString(userAgentString);
        OperatingSystem os = userAgent.getOperatingSystem();
        Browser browser = userAgent.getBrowser();
        int id = userAgent.getId();
        
        StatisticsForm statisticsForm = new StatisticsForm();
        statisticsForm.setOs(os.toString());
        statisticsForm.setBrowser(browser.toString());
        statisticsForm.setId(id);

        statisticsRepository.save(statisticsForm);

        return "statistics";
    }
}
