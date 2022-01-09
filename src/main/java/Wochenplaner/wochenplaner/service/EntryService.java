package Wochenplaner.wochenplaner.service;

import Wochenplaner.wochenplaner.persistence.EntryEntity;
import Wochenplaner.wochenplaner.persistence.EntryGroupRepository;
import Wochenplaner.wochenplaner.persistence.EntryRepository;
import Wochenplaner.wochenplaner.web.api.Entry;
import Wochenplaner.wochenplaner.web.api.EntryManipulateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntryService {
    private final EntryRepository entryRepository;
    private final EntryGroupRepository entryGroupRepository;
    private final EntryGroupTransformer entryGroupTransformer;

    public EntryService(EntryRepository entryRepository, EntryGroupRepository entryGroupRepository, EntryGroupTransformer entryGroupTransformer){
        this.entryRepository = entryRepository;
        this.entryGroupRepository = entryGroupRepository;
        this.entryGroupTransformer = entryGroupTransformer;
    }

    public List<Entry> findAll(){
        List<EntryEntity> entries = entryRepository.findAll();
        return entries.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());

    }

    public Entry findById(Long id){
        var eintragEintity = entryRepository.findById(id);
        return eintragEintity.map(this::transformEntity).orElse(null);
    }

    public Entry create(EntryManipulateRequest request){
        var zuordnung = entryGroupRepository.findById(request.getEntryGroupId()).orElseThrow();
        request.getEntryGroupId();
        var entryEntity = new EntryEntity(request.getName(), request.getBeschreibung(), request.getStatus(), zuordnung);//, request.getAnfangszeit(), request.getEndzeit());
        entryEntity = entryRepository.save(entryEntity);
        return transformEntity(entryEntity);
    }

    public Entry update(Long id, EntryManipulateRequest request){
        var eintragEntityOptional = entryRepository.findById(id);
        if(eintragEntityOptional.isEmpty()){
            return null;
        }

        var entryEntity = eintragEntityOptional.get();
        entryEntity.setName(request.getName());
        entryEntity.setBeschreibung(request.getBeschreibung());
        entryEntity.setStatus(request.getStatus());
       /* entryEntity.setAnfangszeit(request.getAnfangszeit());
        entryEntity.setEndzeit(request.getEndzeit());*/
        entryEntity = entryRepository.save(entryEntity);

        return transformEntity(entryEntity);
    }

    private Entry transformEntity(EntryEntity entryEntity){
        return new Entry(
                entryEntity.getId(),
                entryEntity.getName(),
                entryEntity.getBeschreibung(),
                entryEntity.getStatus(),
                entryGroupTransformer.transformEntity(entryEntity.getZuordnung())
                //entryEntity.getAnfangszeit(),
                //entryEntity.getEndzeit()
        );
    }

    public boolean deleteById(Long id){
       if(!entryRepository.existsById(id)){
           return false;
       }

       entryRepository.deleteById(id);
       return true;
    }
}
