package TronGame.Tron.Controllers;

import TronGame.Tron.Entities.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String getLoginForm() {
        return "login";
    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String login(@ModelAttribute(name="loginForm") LoginForm loginForm, Model model) {

        String SQL = "SELECT * FROM v_users WHERE username='"+loginForm.getUsername()+"'"+
                " and password='"+loginForm.getPassword()+"'";

        try {
            jdbcTemplate.queryForMap(SQL);
        }
        catch (EmptyResultDataAccessException e) {
            model.addAttribute("invalidCredentials", true);
            return "login";
        }
        return "user";
    }
}
