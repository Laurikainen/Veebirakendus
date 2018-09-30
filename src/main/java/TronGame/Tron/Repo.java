package TronGame.Tron;

import TronGame.Tron.Entities.RegistrationForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends JpaRepository<RegistrationForm, String> {

}