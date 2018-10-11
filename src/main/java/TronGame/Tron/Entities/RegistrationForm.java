package TronGame.Tron.Entities;

import javax.persistence.*;

@Entity
@Table(name="users")
public class RegistrationForm {

    @Id
    @Column(name="id")
    private String id;

    @Column(name="name")
    private String name;

    @Column(name="locale")
    private String locale;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocale() { return locale; }
    public void setLocale(String locale) { this.locale = locale; }
}