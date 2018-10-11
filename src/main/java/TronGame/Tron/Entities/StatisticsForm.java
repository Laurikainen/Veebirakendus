package TronGame.Tron.Entities;


import javax.persistence.*;

@Entity
@Table(name="statistics")
public class StatisticsForm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Column(name="os")
    private String os;

    @Column(name="language")
    private String lang;

    @Column(name="architecture")
    private String arc;

    @Column(name="version")
    private String version;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getOs() {
        return os;
    }
    public void setOs(String os) {
        this.os = os;
    }

    public String getLang() {
        return lang;
    }
    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getArc() {
        return arc;
    }
    public void setArc(String arc) {
        this.arc = arc;
    }

    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }
}
