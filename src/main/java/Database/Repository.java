package Database;

import org.springframework.data.repository.CrudRepository;
import Database.User;

public interface Repository extends CrudRepository<User, Integer> {

}
