package TronGame.Tron.Configurations;

import TronGame.Tron.Entities.StatisticsForm;
import TronGame.Tron.Repositories.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class Statistics {

    @Autowired
    private StatisticsRepository statisticsRepository;

    private String OS = System.getProperty("sun.desktop");
    private String arch = System.getProperty("os.arch");
    private String lang = System.getProperty("user.language");
    private String os_name = System.getProperty("os.name");

    public void add_data() {
        StatisticsForm statisticsForm = new StatisticsForm();
        statisticsForm.setId(1);
        statisticsForm.setOs(OS);
        statisticsForm.setArc(arch);
        statisticsForm.setLang(lang);
        statisticsForm.setVersion(os_name);
        statisticsRepository.save(statisticsForm);
        //ResponseEntity.ok().build();
    }
}
