package TronGame.Tron.Controllers;

import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/updateId")
public class UpdateController {

    private double updateID = Math.random();

    @RequestMapping
    @ResponseBody
    public String handleRequest(@RequestParam("Id") String id){
        String updateIdString = Double.toString(updateID);
        while (true) {
            if (!id.equals(updateIdString)) {
                return updateIdString;// + " " + id + " == " + updateIdString;
            }
            else{
                try {
                    //If all is well, just time out, the client will request it again soon enough.
                    TimeUnit.SECONDS.sleep(15);
                }
                catch (InterruptedException e){
                    //Continue along
                }
                //return updateIdString;// + " " + id + " != " + updateIdString;
            }
        }
    }

//    public void exit(HttpServletRequest request, HttpServletResponse response) {
//        // token can be revoked here if needed
//        new SecurityContextLogoutHandler().logout(request, null, null);
//        try {
//            //sending back to client app
//            //response.sendRedirect(request.getHeader("referer"));
//            new DefaultRedirectStrategy().sendRedirect(request, response, "/");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
