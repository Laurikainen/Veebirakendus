package TronGame.Tron.Controllers;

import TronGame.Tron.Entities.RegistrationForm;
import TronGame.Tron.Repositories.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
public class RegistrationController {

    @Autowired
    private Repository Repository;

    @RequestMapping(value="/registration", method=RequestMethod.GET)
    public String getRegistrationForm() {
        return "registration";
    }

    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String register (@ModelAttribute(name="loginForm") RegistrationForm registrationForm, Model model) {

        RegistrationForm user = new RegistrationForm();
        user.setUsername(registrationForm.getUsername());
        user.setName(registrationForm.getName());
        user.setEmail(registrationForm.getEmail());
        user.setPassword(registrationForm.getPassword());
        user.setRegistration(new Date());
        Repository.save(user);
        return "main_page";
    }
    /*@RequestMapping(value="reg", method=RequestMethod.GET)
    public String getRegistrationForm() {
        return "registration";
    }

    @RequestMapping(value="login", method=RequestMethod.POST)
    public String register(@ModelAttribute(name="loginForm") LoginForm loginForm, Model model) {
        String usename = loginForm.getUsername();
        String password = loginForm.getPassword();

        if("admin".equals(username) && "admin".equals(password)) {
            return "main_page";
        }
        model.addAttribute("invalidCredentials", true);
        return "login";
    }*/
}
