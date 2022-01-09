package Wochenplaner.wochenplaner.persistence;

import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalTime;

@Entity(name ="Eintraege")
public class EntryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Bezeichnung", nullable = false)
    private String name;

    @Column(name = "Beschreibung")
    private String beschreibung;

    @Column(name = "Status", nullable = false)
    private String status;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "entryGroup_id", referencedColumnName = "id")
    private EntryGroupEntity zuordnung;

    /*@OneToOne
    @JoinColumn(name= "entryGroup_id", referencedColumnName = "id")
    private EntryGroupEntity zuordnung;*/

   /* @Column(name ="Anfangs-Zeit")
    private LocalTime anfangszeit;

    @Column(name="End-Zeit")
    private LocalTime endzeit;*/

    public EntryEntity(String name, String beschreibung, String status, EntryGroupEntity zuordnung){//, LocalTime anfangszeit, LocalTime endzeit) {
        this.name = name;
        this.beschreibung = beschreibung;
        this.status = status;
        this.zuordnung = zuordnung;
       /* this.anfangszeit = anfangszeit;
        this.endzeit = endzeit;*/
    }

    protected EntryEntity(){}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public EntryGroupEntity getZuordnung() {
        return zuordnung;
    }

    public void setZuordnung(EntryGroupEntity zuordnung) {
        this.zuordnung = zuordnung;
    }

    /* public LocalTime getAnfangszeit(){return anfangszeit;}

    public void setAnfangszeit(LocalTime anfangszeit){this.anfangszeit = anfangszeit;}

    public LocalTime getEndzeit(){return endzeit;}

    public void setEndzeit(LocalTime endzeit){this.endzeit = endzeit;}*/
}
