package Wochenplaner.wochenplaner.persistence;

import Wochenplaner.wochenplaner.web.api.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntryRepository extends JpaRepository<EntryEntity, Long>{
    List<EntryEntity> findAllByName(String name);
}
