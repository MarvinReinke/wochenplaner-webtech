package Wochenplaner.wochenplaner.persistence;

import javax.persistence.*;

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

    public EntryEntity(String name, String beschreibung, String status) {
        this.name = name;
        this.beschreibung = beschreibung;
        this.status = status;
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
}