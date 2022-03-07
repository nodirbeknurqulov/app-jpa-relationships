package uz.pdp.appjparelationships.repository;
// Nurkulov Nodirbek 2/20/2022  10:49 AM

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appjparelationships.entity.Address;
import uz.pdp.appjparelationships.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    boolean existsByName(String name);//query
    boolean existsByNameAndId(String subject, Integer id);
    boolean findByName(String name);
}
