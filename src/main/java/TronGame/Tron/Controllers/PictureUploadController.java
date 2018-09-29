package TronGame.Tron.Controllers;

import TronGame.Tron.Entities.PictureUploadForm;
import com.google.common.io.Files;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLException;

import static com.google.common.io.Files.getFileExtension;

@Controller
public class PictureUploadController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping(value="/upload_picture", method=RequestMethod.GET)
    public String getPictureUploadForm() {
        return "upload_picture";
    }

    @RequestMapping(value="/upload_picture", method=RequestMethod.POST)
    public String pictureUpload (@ModelAttribute(name="pictureUploadForm") PictureUploadForm pictureUploadForm, Model model) throws SQLException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        File image = pictureUploadForm.getData();

        try {
            byte[] bFile = new byte[(int) image.length()];
            FileInputStream fileInputStream = new FileInputStream(image);
            fileInputStream.read(bFile);
            fileInputStream.close();

            String SQL_INSERT = "INSERT INTO pictures(username, name, img_data)" +
                    "values ('"+auth.getName()+"', '"+image.getName()+"', '"+fileInputStream+"')";
            jdbcTemplate.execute(SQL_INSERT);
        }
        catch (Exception e) {
            System.out.println(e);
            /*model.addAttribute("pictureNotUploaded", true);
            return "upload_picture";*/
        }
        model.addAttribute("pictureUploaded", true);
        return "user";




    }
}
