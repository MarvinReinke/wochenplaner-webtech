package Wochenplaner.wochenplaner.persistence;

import Wochenplaner.wochenplaner.web.api.EntryGroup;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="entryGroup")
public class EntryGroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "gruppenBezeichnung")
    private String gruppenBezeichnung;

    @Column(name="gruppenBeschreibung")
    private String gruppenBeschreibung;

    @OneToMany(mappedBy = "zuordnung", fetch = FetchType.EAGER)
    private List<EntryEntity> entries = new ArrayList<>();

    public EntryGroupEntity(String gruppenBezeichnung, String gruppenBeschreibung){
        this.gruppenBezeichnung =gruppenBezeichnung;
        this.gruppenBeschreibung = gruppenBeschreibung;
    }

    public EntryGroupEntity(){}

    public Long getId(){
        return id;
    }

    public String getGruppenBezeichnung(){
        return gruppenBezeichnung;
    }

    public void setGruppenBezeichnung(String gruppenBezeichnung) {
        this.gruppenBezeichnung = gruppenBezeichnung;
    }

    public String getGruppenBeschreibung() {
        return gruppenBeschreibung;
    }

    public void setGruppenBeschreibung(String gruppenBeschreibung) {
        this.gruppenBeschreibung = gruppenBeschreibung;
    }

    public List<EntryEntity> getEntries() {
        return entries;
    }

    public void setEntries(List<EntryEntity> entries) {
        this.entries = entries;
    }
}
