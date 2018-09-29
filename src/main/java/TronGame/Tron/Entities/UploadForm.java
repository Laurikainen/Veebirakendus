package TronGame.Tron.Entities;

import org.springframework.web.multipart.MultipartFile;

public class UploadForm {

    private String id;
    private MultipartFile data;

    public UploadForm() { super(); }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public MultipartFile getData() { return data; }
    public void setData(MultipartFile data) { this.data = data; }
}