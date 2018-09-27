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
import java.util.Date;
import java.util.Map;

@Controller
public class RegistrationController {

    @Autowired
    private TronGame.Tron.Repositories.Repository Repository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping(value="/registration", method=RequestMethod.GET)
    public String getRegistrationForm() {
        return "registration";
    }

    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String register (@ModelAttribute(name="registrationForm") RegistrationForm registrationForm, Model model) throws SQLException {

        String SQL = "SELECT * FROM v_users WHERE username='"+registrationForm.getUsername()+"'";


        try {
            jdbcTemplate.queryForMap(SQL);
        }
        catch (EmptyResultDataAccessException e) {
            RegistrationForm user = new RegistrationForm();
            user.setUsername(registrationForm.getUsername());
            user.setName(registrationForm.getName());
            user.setEmail(registrationForm.getEmail());
            user.setPassword(registrationForm.getPassword());
            user.setRegistration(new Date());
            Repository.save(user);
            return "main_page";
        }
        model.addAttribute("invalidCredentials", true);
        return "registration";



    }
}
