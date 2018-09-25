package TronGame.Tron.Repositories;

import org.springframework.data.repository.CrudRepository;
import TronGame.Tron.Entities.User;

public interface Repository extends CrudRepository<User, Integer> { }
