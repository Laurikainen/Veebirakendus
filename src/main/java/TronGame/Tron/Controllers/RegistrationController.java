package TronGame.Tron.Controllers;

import TronGame.Tron.Entities.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.*;

@Controller
public class RegistrationController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping(value="/registration", method=RequestMethod.GET)
    public String getRegistrationForm() {
        return "registration";
    }

    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String register (@ModelAttribute(name="registrationForm") RegistrationForm registrationForm, Model model) throws SQLException {

        String SQL = "SELECT username FROM v_users WHERE username='"+registrationForm.getUsername()+"'";

        try {
            jdbcTemplate.queryForMap(SQL);
        }
        catch (EmptyResultDataAccessException e) {

            String SQL_INSERT = "INSERT INTO user_data (name, username, password, email, date)" +
                    "values ('"+registrationForm.getName()+"', '"+
                    registrationForm.getUsername()+"', '"+ registrationForm.getPassword()+"', '"+
                    registrationForm.getEmail()+"', '"+java.time.LocalDateTime.now()+"')";
            jdbcTemplate.execute(SQL_INSERT);

            String SQL_ROLES = "INSERT INTO user_role (username, role)" +
                    "values ('"+ registrationForm.getUsername()+"', 'USER')";
            jdbcTemplate.execute(SQL_ROLES);

            return "main_page";
        }
        model.addAttribute("invalidCredentials", true);
        return "registration";



    }
}
