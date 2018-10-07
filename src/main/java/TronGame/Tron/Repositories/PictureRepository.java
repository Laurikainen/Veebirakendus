package TronGame.Tron.Repositories;

import TronGame.Tron.Entities.UploadForm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureRepository extends CrudRepository<UploadForm, String> { }
