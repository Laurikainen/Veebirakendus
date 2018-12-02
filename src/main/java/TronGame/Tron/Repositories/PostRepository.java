package TronGame.Tron.Repositories;

import TronGame.Tron.Entities.PostForm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<PostForm, String> { }