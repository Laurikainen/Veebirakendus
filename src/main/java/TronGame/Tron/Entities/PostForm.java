package TronGame.Tron.Entities;

import javax.persistence.*;

@Entity
@Table(name="post")
public class PostForm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
    @Column(name="title")
    private String title;
    @Column(name="reply")
    private String reply;
    @Column(name="user")
    private String user;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getReply() { return reply; }
    public void setReply(String reply) { this.reply = reply; }

    public String getUser() { return user; }
    public void setUser(String user) { this.user = user; }
}
