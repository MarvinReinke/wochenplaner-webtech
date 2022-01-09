package Wochenplaner.wochenplaner.web.api;

import org.apache.tomcat.jni.Local;
import java.time.LocalTime;

public class Entry {
    private Long id;
    private String name;
    private String beschreibung;
    private String status;
    private EntryGroup entryGroup;
    /*private LocalTime anfangsZeit;
    private LocalTime endZeit;*/

    public Entry(long id, String name, String beschreibung, String status,EntryGroup entryGroup ){//, LocalTime anfangsZeit, LocalTime endZeit) {
        this.id = id;
        this.name = name;
        this.beschreibung = beschreibung;
        this.status = status;
        this.entryGroup = entryGroup;
       /* this.anfangsZeit = anfangsZeit;
        this.endZeit = endZeit;*/
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public EntryGroup getEntryGroup() {
        return entryGroup;
    }

    public void setEntryGroup(EntryGroup entryGroup) {
        this.entryGroup = entryGroup;
    }

   /* public LocalTime getAnfangsZeit() {
        return anfangsZeit;
    }

    public void setAnfangsZeit(LocalTime anfangsZeit) {
        this.anfangsZeit = anfangsZeit;
    }

    public LocalTime getEndZeit() {
        return endZeit;
    }

    public void setEndZeit(LocalTime endZeit) {
        this.endZeit = endZeit;
    }*/
}
