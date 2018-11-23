package TronGame.Tron.Controllers;

import TronGame.Tron.Entities.RegistrationForm;
import TronGame.Tron.Entities.UploadForm;
import TronGame.Tron.Repositories.PictureRepository;
import TronGame.Tron.Repositories.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.*;

@Controller
public class UserController {

    @Autowired
    private PictureRepository pictureRepository;

    @Autowired
    private RegistrationRepository registrationRepository;

    @RequestMapping("/user")
    public String getUser(Principal principal, Model model) {
        Map<String, Object> data = (Map<String, Object>) ((OAuth2Authentication) principal).getUserAuthentication().getDetails();
        RegistrationForm user = registrationRepository.findByPrincipal((String) data.get("id"));
        if (user == null) {
            registrationRepository.register((String) data.get("id"), (String) data.get("name"), (String) data.get("locale"));
        }

        String str = registrationRepository.joinByPrincipal((String) data.get("id"));
        String[] pieces = str.split(",");

        model.addAttribute("id", pieces[0]);
        model.addAttribute("name",pieces[1]);
        model.addAttribute("locale", pieces[2]);
        model.addAttribute("picture_name", pieces[3]);
        model.addAttribute("type", pieces[4]);

        Optional<UploadForm> uploadForm = pictureRepository.findById((String) data.get("id"));
        if (uploadForm.isPresent()) {
            byte[] array = uploadForm.get().getData();
            String base64 = "data:" + uploadForm.get().getType() + ";base64, " + Base64Utils.encodeToString(array);
            model.addAttribute("image", base64);
            return "user";
        }

        return "upload";
    }
}
