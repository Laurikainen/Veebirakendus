package TronGame.Tron.Controllers;

import TronGame.Tron.Entities.StatisticsForm;
import TronGame.Tron.Repositories.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StatisticsController {

    @Autowired
    private StatisticsRepository statisticsRepository;

    private String OS = System.getProperty("sun.desktop");
    private String arch = System.getProperty("os.arch");
    private String lang = System.getProperty("user.language");
    private String os_name = System.getProperty("os.name");

    @RequestMapping ("/statistics")
    public String statistics(){

        StatisticsForm statisticsForm = new StatisticsForm();
        statisticsForm.setOs(OS);
        statisticsForm.setArc(arch);
        statisticsForm.setLang(lang);
        statisticsForm.setVersion(os_name);
        statisticsRepository.save(statisticsForm);

        return "statistics";
    }
}
