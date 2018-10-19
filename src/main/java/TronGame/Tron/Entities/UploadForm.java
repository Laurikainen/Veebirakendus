package TronGame.Tron.Entities;

import javax.persistence.*;

@Entity
    @Table(name="profile")
public class UploadForm {

    @Id
    @Column(name="username")
    private String username;

    @Column(name="picture")
    @Lob
    private byte[] data;

    @Column(name="title")
    private String title;

    @Column (name="type")
    private  String type;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}