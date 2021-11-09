package Wochenplaner.wochenplaner.web;

import Wochenplaner.wochenplaner.web.api.Eintrag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EintragRestController {

    private List <Eintrag> eintrage;

    public EintragRestController(){
        eintrage = new ArrayList<>();
        eintrage.add(new Eintrag(1, "Vorlesung-webtech", "Vorlesung im Modul Webtech", "aktiv"));
        eintrage.add(new Eintrag(2, "Mittagessen", "zu der Zeit esse ich etwas", "aktiv"));
    }

    @GetMapping(path = "/api/v1/eintrag")
    public ResponseEntity<List<Eintrag>> fetchEintrage(){
        return ResponseEntity.ok(eintrage);
    }
}

