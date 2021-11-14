package Wochenplaner.wochenplaner.service;

import Wochenplaner.wochenplaner.persistence.EintragEntity;
import Wochenplaner.wochenplaner.persistence.EintragRepository;
import Wochenplaner.wochenplaner.web.api.Eintrag;
import Wochenplaner.wochenplaner.web.api.EintragManipulateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EintragService {
    private final EintragRepository eintragRepository;

    public EintragService(EintragRepository eintragRepository){
        this.eintragRepository = eintragRepository;

    }

    public List<Eintrag> findAll(){
        List<EintragEntity> eintraege = eintragRepository.findAll();
        return eintraege.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());

    }

    public Eintrag findById(Long id){
        var eintragEintity = eintragRepository.findById(id);
        return eintragEintity.map(this::transformEntity).orElse(null);
    }

    public Eintrag create(EintragManipulateRequest request){
        var eintragEntity = new EintragEntity(request.getName(), request.getBeschreibung(), request.getStatus());
        eintragEntity = eintragRepository.save(eintragEntity);
        return transformEntity(eintragEntity);
    }

    public Eintrag update(Long id, EintragManipulateRequest request){
        var eintragEntityOptional = eintragRepository.findById(id);
        if(eintragEntityOptional.isEmpty()){
            return null;
        }

        var eintragEntity = eintragEntityOptional.get();
        eintragEntity.setName(request.getName());
        eintragEntity.setBeschreibung(request.getBeschreibung());
        eintragEntity.setStatus(request.getStatus());
        eintragEntity = eintragRepository.save(eintragEntity);

        return transformEntity(eintragEntity);
    }

    private Eintrag transformEntity(EintragEntity eintragEntity){
        return new Eintrag(
                eintragEntity.getId(),
                eintragEntity.getName(),
                eintragEntity.getBeschreibung(),
                eintragEntity.getStatus()
        );
    }

    public boolean deleteById(Long id){
       if(!eintragRepository.existsById(id)){
           return false;
       }

       eintragRepository.deleteById(id);
       return true;
    }
}
