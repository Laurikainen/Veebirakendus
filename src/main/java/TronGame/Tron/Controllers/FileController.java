package TronGame.Tron.Controllers;

import TronGame.Tron.Entities.UploadForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Map;

@Controller
public class FileController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping(value="/upload", method=RequestMethod.GET)
    public String getUploadForm() {
        return "upload";
    }

    @RequestMapping(value="/upload", method=RequestMethod.POST)
    public String upload(@ModelAttribute(name="uploadForm") UploadForm uploadForm, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        MultipartFile file = uploadForm.getData();
        try {
            try {
                String SQL = "SELECT * FROM pictures WHERE username='"+auth.getName()+"'";
                Map<String, Object> map = jdbcTemplate.queryForMap(SQL);
                model.addAttribute("pictureExists", true);
                return "upload";
            }
            catch (Exception e) {
                String SQL_INSERT = "INSERT INTO pictures(username, file_name, img_data)" +
                        "values ('" + auth.getName() + "', '" + file.getOriginalFilename() + "', '" + file.getBytes() + "')";
                jdbcTemplate.execute(SQL_INSERT);
            }
        } catch (IOException ex) {
            model.addAttribute("pictureNotUploaded", true);
            return "upload";
        }
        model.addAttribute("pictureUploaded", true);
        return "upload";

    }
}
