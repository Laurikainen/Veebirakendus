package TronGame.Tron.Entities;

import javax.persistence.*;

@Entity
@Table(name="thread")
public class ForumForm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
    @Column(name="title")
    private String title;
    @Column(name="context")
    private String context;
    @Column(name="user")
    private String user;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContext() { return context; }
    public void setContext(String context) { this.context = context; }

    public String getUser() { return user; }
    public void setUser(String user) { this.user = user; }
}
