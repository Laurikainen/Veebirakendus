package TronGame.Tron.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /*@Autowired
    private Repo repo;

    @GetMapping("/notes")
    public List<RegistrationForm> getAllNotes() {
        return repo.findAll();
    }*/

    @RequestMapping("/user")
    public ModelAndView user() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ModelAndView maw = new ModelAndView("user");
        Map<String, Object> map;
        try {
            String SQL = "SELECT user_data.name, user_data.username, user_data.email, pictures.file_name, pictures.data " +
                    "FROM user_data JOIN pictures on user_data.username=pictures.username WHERE user_data.username='"+auth.getName()+"'";
            map = jdbcTemplate.queryForMap(SQL);

            Object name = map.get("name");
            Object username = map.get("username");
            Object email = map.get("email");
            Object picture_name = map.get("file_name");
            Object picture = map.get("picture");

            maw.addObject("dbname", name);
            maw.addObject("dbusername", username);
            maw.addObject("dbemail", email);
            maw.addObject("dbpicture_name", picture_name);
            maw.addObject("dbpicture", picture);

        } catch (Exception e) {
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

    /*// Delete a Note
    @DeleteMapping("/notes/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        noteRepository.delete(note);

        return ResponseEntity.ok().build();
    }*/

    /*// Update a Note
    @PutMapping("/notes/{id}")
    public Note updateNote(@PathVariable(value = "id") Long noteId,
                           @Valid @RequestBody Note noteDetails) {

        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        note.setTitle(noteDetails.getTitle());
        note.setContent(noteDetails.getContent());

        Note updatedNote = noteRepository.save(note);
        return updatedNote;
    }*/
}
