package TronGame.Tron.Repositories;

import TronGame.Tron.Entities.StatisticsForm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticsRepository extends CrudRepository<StatisticsForm, Integer> { }