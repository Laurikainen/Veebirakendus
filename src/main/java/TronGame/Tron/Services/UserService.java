package TronGame.Tron.Services;

import TronGame.Tron.Entities.RegistrationForm;
import TronGame.Tron.Repositories.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private RegistrationRepository registrationRepository;

    public RegistrationForm newUser(Principal principal) {
        Map<String, Object> data = (Map<String, Object>) ((OAuth2Authentication) principal).getUserAuthentication().getDetails();

        String firstName = (String) data.get("given_name");
        String lastName = (String) data.get("family_name");
        String email = (String) data.get("email");

        RegistrationForm user = registrationRepository.findByEmail(email);

        if (user == null) {
            user = new RegistrationForm();
            user.setEmail(email);
            user.setFirstname(firstName);
            user.setLastname(lastName);
            registrationRepository.save(user);
        }

        return user;
    }

    public RegistrationForm getUser(Principal principal) {
        if(principal == null) {
            return null;
        }
        Map<String, Object> data = (Map<String, Object>) ((OAuth2Authentication) principal).getUserAuthentication().getDetails();

        RegistrationForm registrationForm = registrationRepository.findByEmail((String)data.get("email"));

        if(registrationForm == null) {
            return newUser(principal);
        }

        return registrationForm;
    }
}