package Wochenplaner.wochenplaner.web.api;

import org.apache.tomcat.jni.Local;

import java.time.LocalTime;

public class EntryManipulateRequest {

    private String name;
    private String beschreibung;
    private String status;
    private Long entryGroupId;
   /* private LocalTime anfangszeit;
    private LocalTime endzeit;*/

    public EntryManipulateRequest(String name, String beschreibung, String status, Long entryGroupId){//, LocalTime anfangszeit, LocalTime endzeit) {
        this.name = name;
        this.beschreibung = beschreibung;
        this.status = status;
        this.entryGroupId = entryGroupId;
       /* this.anfangszeit = anfangszeit;
        this.endzeit = endzeit;*/
    }

    public EntryManipulateRequest(){}

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

    public Long getEntryGroupId() {
        return entryGroupId;
    }

    public void setEntryGroupId(Long entryGroupId) {
        this.entryGroupId = entryGroupId;
    }

    /*public LocalTime getAnfangszeit(){return anfangszeit;}

    public void setAnfangszeit(){this.anfangszeit = anfangszeit;}

    public LocalTime getEndzeit(){return endzeit;}

    public void setEndzeit() {this.endzeit = endzeit;}*/
}
