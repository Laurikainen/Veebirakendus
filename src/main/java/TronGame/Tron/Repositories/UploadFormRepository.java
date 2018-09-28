package TronGame.Tron.Repositories;

import TronGame.Tron.Entities.UploadForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UploadFormRepository extends JpaRepository<UploadForm, String> {

}
