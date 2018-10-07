package TronGame.Tron.Entities;
import org.springframework.web.multipart.MultipartFile;

public class PictureForm {

    private MultipartFile data;

    public MultipartFile getData() { return data; }
    public void setData(MultipartFile data) { this.data = data; }
}
