package Wochenplaner.wochenplaner.web;

import Wochenplaner.wochenplaner.service.EntryService;
import Wochenplaner.wochenplaner.web.api.Entry;
import Wochenplaner.wochenplaner.web.api.EntryManipulateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class EntryRestController {


    private final EntryService entryService;

    public EntryRestController(EntryService entryService){
        this.entryService = entryService;
    }

    @GetMapping(path = "/api/v1/entries")
    public ResponseEntity<List<Entry>> fetchEntries(){
        return ResponseEntity.ok(entryService.findAll());
    }

    @PostMapping(path = "/api/v1/entries")
    public ResponseEntity<Void> createEntry(@RequestBody EntryManipulateRequest request) throws URISyntaxException {
        var entry = entryService.create(request);
        URI uri = new URI("/api/v1/entries/" + entry.getId());
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(path = "/api/v1/entries/{id}")
    public ResponseEntity<Entry> fetchEntryById(@PathVariable Long id){
    var entry = entryService.findById(id);
    return entry != null? ResponseEntity.ok(entry) : ResponseEntity.notFound().build();
    }

    @PutMapping(path = "/api/v1/entries/{id}")
    public ResponseEntity<Entry> updateEntry(@PathVariable Long id, @RequestBody EntryManipulateRequest request){
    var entry = entryService.update(id, request);
    return entry != null? ResponseEntity.ok(entry) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/entries/{id}")
    public ResponseEntity<Void> deleteEntry(@PathVariable Long id){
        boolean successful = entryService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}

