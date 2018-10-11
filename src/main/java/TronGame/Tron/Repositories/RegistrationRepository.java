package TronGame.Tron.Repositories;

import TronGame.Tron.Entities.RegistrationForm;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationRepository extends CrudRepository<RegistrationForm, Integer> {

    @Modifying
    @Query(value = "INSERT INTO users (id, name, locale) VALUES (:id, :name, :locale)", nativeQuery = true)
    RegistrationForm register(@Param("id") String id, @Param("name") String name, @Param("locale") String locale);

    @Query(value = "SELECT * FROM users JOIN profile ON users.id=profile.username WHERE users.id=(:id)", nativeQuery = true)
    List<Object> joinByPrincipal(@Param("id") String id);

    @Query(value = "SELECT * FROM users WHERE id=(:id)", nativeQuery = true)
    RegistrationForm findByPrincipal(@Param("id") String id);
}
