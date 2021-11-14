package Wochenplaner.wochenplaner.web;

import Wochenplaner.wochenplaner.service.EintragService;
import Wochenplaner.wochenplaner.web.api.Eintrag;
import Wochenplaner.wochenplaner.web.api.EintragManipulateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class EintragRestController {


    private final EintragService eintragService;

    public EintragRestController(EintragService eintragService){
        this.eintragService = eintragService;
    }

    @GetMapping(path = "/api/v1/eintrag")
    public ResponseEntity<List<Eintrag>> fetchEintrage(){
        return ResponseEntity.ok(eintragService.findAll());
    }

    @PostMapping(path = "/api/v1/eintrag")
    public ResponseEntity<Void> createEintrag(@RequestBody EintragManipulateRequest request) throws URISyntaxException {
        var eintrag = eintragService.create(request);
        URI uri = new URI("/api/v1/eintrag/" + eintrag.getId());
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(path = "/api/v1/eintrag/{id}")
    public ResponseEntity<Eintrag> fetchEintragById(@PathVariable Long id){
    var eintrag = eintragService.findById(id);
    return eintrag != null? ResponseEntity.ok(eintrag) : ResponseEntity.notFound().build();
    }

    @PutMapping(path = "/api/v1/eintrag/{id}")
    public ResponseEntity<Eintrag> updateEintrag(@PathVariable Long id, @RequestBody EintragManipulateRequest request){
    var eintrag = eintragService.update(id, request);
    return eintrag != null? ResponseEntity.ok(eintrag) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/eintrag/{id}")
    public ResponseEntity<Void> deleteEintrag(@PathVariable Long id){
        boolean successful = eintragService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}

