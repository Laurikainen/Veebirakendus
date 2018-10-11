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
        Map<String, Object> details = (Map<String, Object>) ((OAuth2Authentication) principal).getUserAuthentication().getDetails();

        String firstName = (String) details.get("given_name");
        String lastName = (String) details.get("family_name");
        String email = (String) details.get("email");

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
}