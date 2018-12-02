package TronGame.Tron.Controllers;

import TronGame.Tron.Entities.ForumForm;
import TronGame.Tron.Entities.ForumInputForm;
import TronGame.Tron.Entities.PostForm;
import TronGame.Tron.Entities.PostInputForm;
import TronGame.Tron.Repositories.ForumRepository;
import TronGame.Tron.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ForumController {

    @Autowired
    private ForumRepository forumRepository;

    @Autowired
    private PostRepository postRepository;

    @RequestMapping("/forum")
    public String forum(Model model){
        List<ForumForm> forumForms = (List<ForumForm>) forumRepository.findAll();
        model.addAttribute("form", forumForms);
        model.addAttribute("thread_created", true);
        return "forum";
    }

    @RequestMapping(value = "/new_thread", method = RequestMethod.GET)
    public String getForumForm() { return "new_thread"; }

    @RequestMapping(value = "/new_thread", method = RequestMethod.POST)
    public String addForumForm(@ModelAttribute(name = "forumInputForm") ForumInputForm forumInputForm){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ForumForm forumForm = new ForumForm();
        forumForm.setTitle(forumInputForm.getTitle());
        forumForm.setContext(forumInputForm.getContext());
        forumForm.setUser(auth.getName());
        forumRepository.save(forumForm);
        return "new_thread";
    }

    @RequestMapping(value = "/new_post/{id}", method = RequestMethod.GET)
    public String getPostForm(@PathVariable int id, Model model) {
        model.addAttribute("id", id);
        return "new_post";
    }

    @RequestMapping(value = "/new_post/{id}", method = RequestMethod.POST)
    public String addPostForm(@PathVariable int id, @ModelAttribute(name="postInputForm") PostInputForm postInputForm, Model model){
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            PostForm postForm = new PostForm();
            postForm.setTitle(forumRepository.findByPrincipal(id).getTitle());
            postForm.setReply(postInputForm.getReply());
            postForm.setUser(auth.getName());
            postRepository.save(postForm);
            ResponseEntity.ok().build();
            model.addAttribute("post_added", true);
        }
        catch (Exception e) {
            model.addAttribute("post_not_added", true);
        }

        return "new_post";
    }

    @RequestMapping(value = "/post/{id}")
    public String getPost(@PathVariable int id, Model model) {
        ForumForm forumForm = forumRepository.findByPrincipal(id);
        model.addAttribute("form", forumForm);
        List<PostForm> postForm = (List<PostForm>) postRepository.findAll();
        List<PostForm> suitable = new ArrayList<>();
        if (postForm.size()>0) {
            for (PostForm form : postForm) {
                if (form.getTitle().equals(forumForm.getTitle())) {suitable.add(form); }
            }
        }
        model.addAttribute("replies", suitable);
        return "post";
    }
}
