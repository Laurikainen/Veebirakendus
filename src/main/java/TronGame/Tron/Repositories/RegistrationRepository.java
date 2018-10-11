package TronGame.Tron.Repositories;

import TronGame.Tron.Entities.RegistrationForm;
import TronGame.Tron.Entities.StatisticsForm;
import TronGame.Tron.Entities.UploadForm;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationRepository extends CrudRepository<RegistrationForm, Integer> {

    @Query(value = "INSERT INTO users (id, firstname, lastname, email) VALUES (:#{#registrationForm.id}, :#{#registrationForm.firstname}, :#{#registrationForm.lastname}, :#{#registrationForm.email})", nativeQuery = true)
    List<StatisticsForm> form();

    @Query(value = "SELECT * FROM v_users WHERE email=(:email)", nativeQuery = true)
    RegistrationForm findByEmail(@Param("email") String email);
}
