package TronGame.Tron.Controllers;

import TronGame.Tron.Entities.PictureForm;
import TronGame.Tron.Entities.SendEmail;
import TronGame.Tron.Entities.UploadForm;
import TronGame.Tron.Repositories.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.naming.SizeLimitExceededException;
import java.security.Principal;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Controller
public class PictureController {

    @Autowired
    private PictureRepository pictureRepository;

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String getPictureForm() { return "upload"; }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String addPictureForm(@ModelAttribute(name="pictureForm") PictureForm pictureForm, Model model, Principal principal){
        Map<String, Object> get_email = (Map<String, Object>) ((OAuth2Authentication) principal).getUserAuthentication().getDetails();
        String email = (String) get_email.get("email");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        MultipartFile data = pictureForm.getData();
        try {
            Optional<UploadForm> upload = pictureRepository.findById(auth.getName());
            if (upload.isPresent()) {
                model.addAttribute("picture_exists", true);
            }
            else if (Objects.equals(data.getContentType(), "image/jpeg") || Objects.equals(data.getContentType(), "image/png")) {
                UploadForm uploadForm = new UploadForm();
                uploadForm.setUsername(auth.getName());
                uploadForm.setData(data.getBytes());
                uploadForm.setTitle(data.getOriginalFilename());
                uploadForm.setType(data.getContentType());
                pictureRepository.save(uploadForm);
                ResponseEntity.ok().build();
                model.addAttribute("picture_uploaded", true);
                new SendEmail().sendEmail(email);
            }
        }
        catch (Exception e) {
            model.addAttribute("picture_not_uploaded", true);
        }
        return "upload";
    }



    @RequestMapping(value = "/delete")
    public String deletePicture(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        pictureRepository.deleteById(auth.getName());
        ResponseEntity.ok().build();
        model.addAttribute("picture_deleted", true);
        return "upload";
    }
}

