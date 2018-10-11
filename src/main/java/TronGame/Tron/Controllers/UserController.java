package TronGame.Tron.Controllers;

import TronGame.Tron.Entities.RegistrationForm;
import TronGame.Tron.Entities.UploadForm;
import TronGame.Tron.Repositories.PictureRepository;
import TronGame.Tron.Repositories.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

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
            //registrationRepository.register((String) data.get("id"), (String) data.get("name"), (String) data.get("locale"));
        }

        List<Object> list = registrationRepository.joinByPrincipal((String) data.get("id"));
        System.out.println(list);
        for (int i=0; i<list.size(); i++) {
            System.out.println(i);
        }

        Optional<UploadForm> uploadForm = pictureRepository.findById((String) data.get("id"));
        if (uploadForm.isPresent()) {
            model.addAttribute("uploadForm", uploadForm.get()); //Pole vaja
            byte[] array = uploadForm.get().getData();
            String base64 = "data:" + uploadForm.get().getType() + ";base64, " + Base64Utils.encodeToString(array);
            model.addAttribute("image", base64);
            return "picture";
        }
        return "upload";
    }
}
