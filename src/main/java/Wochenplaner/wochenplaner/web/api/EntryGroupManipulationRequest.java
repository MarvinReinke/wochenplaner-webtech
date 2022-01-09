package Wochenplaner.wochenplaner.web.api;

import Wochenplaner.wochenplaner.persistence.EntryGroupEntity;

public class EntryGroupManipulationRequest {

    private String gruppenBezeichnung;
    private String gruppenBeschreibung;

    public EntryGroupManipulationRequest(String gruppenBezeichnung, String gruppenBeschreibung) {
        this.gruppenBezeichnung = gruppenBezeichnung;
        this.gruppenBeschreibung = gruppenBeschreibung;
    }

    public EntryGroupManipulationRequest(){}

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
}

