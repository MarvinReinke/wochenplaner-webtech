package Wochenplaner.wochenplaner.web;

import Wochenplaner.wochenplaner.service.EntryGroupService;
import Wochenplaner.wochenplaner.web.api.EntryGroup;
import Wochenplaner.wochenplaner.web.api.EntryGroupManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
@RestController
public class EntryGroupRestController {
    private final EntryGroupService entryGroupService;

    public EntryGroupRestController(EntryGroupService entryGroupService){
        this.entryGroupService = entryGroupService;
    }

    @GetMapping(path="/api/v1/entryGroups")
    public ResponseEntity<List<EntryGroup>> fetchEntryGroups(){
        return ResponseEntity.ok(entryGroupService.findAll());
    }

    @PostMapping(path="/api/v1/entryGroups")
    public ResponseEntity<Void> createEntryGroup(@RequestBody EntryGroupManipulationRequest request) throws URISyntaxException {
       var entryGroup = entryGroupService.create(request);
       URI uri = new URI("/api/v1/entryGroups"+entryGroup.getId());
       return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(path = "/api/v1/entryGroups/{id}")
    public ResponseEntity<Void> deleteEntry(@PathVariable Long id){
        boolean successful = entryGroupService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}
