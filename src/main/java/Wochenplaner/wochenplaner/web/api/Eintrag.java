package Wochenplaner.wochenplaner.web.api;

public class Eintrag {
    private long id;
    private String name;
    private String beschreibung;
    private String status;

    public Eintrag(long id, String name, String beschreibung, String status) {
        this.id = id;
        this.name = name;
        this.beschreibung = beschreibung;
        this.status = status;
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
}
