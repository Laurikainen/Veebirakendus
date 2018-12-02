package TronGame.Tron.Repositories;

import TronGame.Tron.Entities.ForumForm;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ForumRepository extends CrudRepository<ForumForm, String> {

    @Query(value = "SELECT * FROM thread WHERE id=(:id)", nativeQuery = true)
    ForumForm findByPrincipal(@Param("id") Integer id);
}