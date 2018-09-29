package TronGame.Tron.Entities;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.File;

@Entity
@Table(name = "pictures")
public class PictureUploadForm {

    @Id
    private String id;
    private File data;

    public PictureUploadForm() { super(); }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public File getData() { return data; }
    public void setData(File data) { this.data = data; }
}
