package TronGame.Tron.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="user_data")
public class User {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer Id;
    @Column(name="name")
    private String username;
    @Column(name="username")
    private String name;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="date")
    private Date registration;

    public Integer getId() {
        return Id;
    }
    public void setId(Integer id) { Id = id; }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegistration() { return registration; }

    public void setRegistration(Date registration) { this.registration = registration; }
}