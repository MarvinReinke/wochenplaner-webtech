package Wochenplaner.wochenplaner.web.api;

public class EntryManipulateRequest {

    private String name;
    private String beschreibung;
    private String status;

    public EntryManipulateRequest(String name, String beschreibung, String status) {
        this.name = name;
        this.beschreibung = beschreibung;
        this.status = status;
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
