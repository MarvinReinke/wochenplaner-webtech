package Wochenplaner.wochenplaner.persistence;

import Wochenplaner.wochenplaner.web.api.Eintrag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EintragRepository extends JpaRepository<EintragEntity, Long>{

    List<EintragEntity> findAllByName(String name);
}
