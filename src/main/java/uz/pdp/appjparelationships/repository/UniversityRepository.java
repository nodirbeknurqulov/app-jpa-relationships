package uz.pdp.appjparelationships.repository;
// Nurkulov Nodirbek 2/20/2022  9:43 AM

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.appjparelationships.entity.University;
@Repository
public interface UniversityRepository extends JpaRepository <University, Integer>{
}
