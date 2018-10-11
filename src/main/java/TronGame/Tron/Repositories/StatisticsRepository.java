package TronGame.Tron.Repositories;

import TronGame.Tron.Entities.StatisticsForm;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatisticsRepository extends CrudRepository<StatisticsForm, Integer> {

    @Query(value = "SELECT browser FROM statistics GROUP BY browser", nativeQuery = true)
    List<Object> browsers();
    @Query(value = "SELECT COUNT(*) FROM statistics GROUP BY browser", nativeQuery = true)
    List<Object> browsers_count();

    @Query(value = "SELECT os FROM statistics GROUP BY os", nativeQuery = true)
    List<Object> os();
    @Query(value = "SELECT COUNT(*) FROM statistics GROUP BY os", nativeQuery = true)
    List<Object> os_count();

    @Query(value = "SELECT user_id FROM statistics GROUP BY user_id", nativeQuery = true)
    List<Object> id();
    @Query(value = "SELECT COUNT(*) FROM statistics GROUP BY user_id", nativeQuery = true)
    List<Object> id_count();
}