package Wochenplaner.wochenplaner.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface EntryGroupRepository extends JpaRepository<EntryGroupEntity, Long> {
}
