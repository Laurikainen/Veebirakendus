package TronGame.Tron.Controllers;

import TronGame.Tron.Entities.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping(value="/registration", method=RequestMethod.GET)
    public String getRegistrationForm() { return "registration"; }

    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String register (@ModelAttribute(name="registrationForm") RegistrationForm registrationForm, Model model) {

        String SQL = "SELECT username FROM users WHERE username='"+registrationForm.getUsername()+"'";

        try {
            jdbcTemplate.queryForMap(SQL);
        }
        catch (EmptyResultDataAccessException e) {

            String SQL_INSERT = "INSERT INTO user_data (name, username, email, date)" +
                    "values ('"+registrationForm.getName()+"', '"+
                    registrationForm.getUsername()+"', '"+ registrationForm.getEmail()+"'," +
                    " '"+java.time.LocalDateTime.now()+"')";
            jdbcTemplate.execute(SQL_INSERT);

            String SQL_USERS = "INSERT INTO users (username, password, enabled)" +
                    "values ('"+ registrationForm.getUsername()+"', '"+ registrationForm.getPassword()+"', TRUE)";
            jdbcTemplate.execute(SQL_USERS);

            String SQL_ROLES = "INSERT INTO authorities (username, authority)" +
                    "values ('"+ registrationForm.getUsername()+"', 'USERS')";
            jdbcTemplate.execute(SQL_ROLES);

            return "main_page";
        }
        model.addAttribute("invalidCredentials", true);
        return "registration";
    }
}