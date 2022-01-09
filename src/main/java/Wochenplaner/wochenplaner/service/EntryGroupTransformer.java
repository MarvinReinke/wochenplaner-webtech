package Wochenplaner.wochenplaner.service;

import Wochenplaner.wochenplaner.persistence.EntryEntity;
import Wochenplaner.wochenplaner.persistence.EntryGroupEntity;
import Wochenplaner.wochenplaner.web.api.Entry;
import Wochenplaner.wochenplaner.web.api.EntryGroup;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class EntryGroupTransformer {
    public EntryGroup transformEntity(EntryGroupEntity entryGroupEntity) {
        var entryIds = entryGroupEntity.getEntries().stream().map(EntryEntity::getId).collect(Collectors.toList());
        return new EntryGroup(
                entryGroupEntity.getId(),
                entryGroupEntity.getGruppenBezeichnung(),
                entryGroupEntity.getGruppenBeschreibung(),
                entryIds
        );
    }
}
