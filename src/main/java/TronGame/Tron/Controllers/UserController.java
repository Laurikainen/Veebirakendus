package TronGame.Tron.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class UserController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /*@GetMapping("/notes")
    public List<RegistrationForm> getAllNotes() {
        return repo.findAll();
    }*/

    @RequestMapping("/user")
    public ModelAndView user() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ModelAndView maw = new ModelAndView("user");
        Map<String, Object> map;
        try {
            String SQL = "SELECT user_data.name, user_data.username, user_data.email, pictures.file_name" +
                    " FROM user_data JOIN pictures on user_data.username=pictures.username WHERE user_data.username='"+auth.getName()+"'";
            map = jdbcTemplate.queryForMap(SQL);

            Object name = map.get("name");
            Object username = map.get("username");
            Object email = map.get("email");
            Object picture_name = map.get("file_name");

            maw.addObject("dbname", name);
            maw.addObject("dbusername", username);
            maw.addObject("dbemail", email);
            maw.addObject("dbpicture_name", picture_name);

            String SQL_BLOB = "SELECT img_data FROM pictures WHERE username='"+auth.getName()+"'";
            map = jdbcTemplate.queryForMap(SQL_BLOB);
            StringBuilder str = new StringBuilder();
                byte[] blob = (byte[]) map.get("img_data");
                for (int i = 0; i < blob.length; i++) {
                    str.append(blob[i]);
                }

            System.out.println(str);
            maw.addObject("dbpicture", blob);
            maw.addObject("dbpic", "<img id='profileImage' src='data:image/png;base64, "+ str +"'>");

        } catch (Exception e) {
            System.out.println(e);
            String SQL = "SELECT name, username, email " +
                    "FROM user_data WHERE username='"+auth.getName()+"'";
            map = jdbcTemplate.queryForMap(SQL);

            Object name = map.get("name");
            Object username = map.get("username");
            Object email = map.get("email");

            maw.addObject("dbname", name);
            maw.addObject("dbusername", username);
            maw.addObject("dbemail", email);
        }
        return maw;

    }
}
