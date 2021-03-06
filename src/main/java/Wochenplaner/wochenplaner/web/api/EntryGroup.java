package Wochenplaner.wochenplaner.web.api;

import java.util.List;

public class EntryGroup {
    private long id;
    private String gruppenBezeichnung;
    private String gruppenBeschreibung;
    private List<Long> entryIds;

    public EntryGroup(long id, String gruppenBezeichnung, String gruppenBeschreibung, List<Long> entryIds) {
        this.id = id;
        this.gruppenBezeichnung = gruppenBezeichnung;
        this.gruppenBeschreibung = gruppenBeschreibung;
        this.entryIds = entryIds;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGruppenBezeichnung() {
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

    public List<Long> getEntryIds() {
        return entryIds;
    }

    public void setEntryIds(List<Long> entryIds) {
        this.entryIds = entryIds;
    }
}
