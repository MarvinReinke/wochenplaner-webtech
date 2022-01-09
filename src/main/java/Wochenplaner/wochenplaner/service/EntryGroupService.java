package Wochenplaner.wochenplaner.service;

import Wochenplaner.wochenplaner.persistence.EntryGroupEntity;
import Wochenplaner.wochenplaner.persistence.EntryGroupRepository;
import Wochenplaner.wochenplaner.web.api.EntryGroup;
import Wochenplaner.wochenplaner.web.api.EntryGroupManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntryGroupService {
    private final EntryGroupRepository entryGroupRepository;
    private final EntryGroupTransformer entryGroupTransformer;


    public EntryGroupService(EntryGroupRepository entryGroupRepository, EntryGroupTransformer entryGroupTransformer) {
        this.entryGroupRepository = entryGroupRepository;
        this.entryGroupTransformer = entryGroupTransformer;
    }

    public List<EntryGroup> findAll() {
        List<EntryGroupEntity> entryGroups = entryGroupRepository.findAll();
        return entryGroups.stream()
                .map(entryGroupTransformer::transformEntity)
                .collect(Collectors.toList());
    }

    public EntryGroup create(EntryGroupManipulationRequest request) {
        var entryGroupEntity = new EntryGroupEntity(request.getGruppenBezeichnung(), request.getGruppenBeschreibung());
        entryGroupEntity = entryGroupRepository.save(entryGroupEntity);
        return entryGroupTransformer.transformEntity(entryGroupEntity);

    }

    /*public EntryGroup transformEntity(EntryGroupEntity entryGroupEntity) {
        return new EntryGroup(
                entryGroupEntity.getId(),
                entryGroupEntity.getGruppenBezeichnung(),
                entryGroupEntity.getGruppenBeschreibung()
        );
    }*/

    public boolean deleteById(Long id) {
        if (!entryGroupRepository.existsById(id)) {
            return false;
        }
        entryGroupRepository.deleteById(id);
        return true;
    }
}
