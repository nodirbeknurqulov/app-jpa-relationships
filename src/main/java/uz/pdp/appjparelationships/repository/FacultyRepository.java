package uz.pdp.appjparelationships.repository;

// Nurkulov Nodirbek 2/20/2022  10:49 AM

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appjparelationships.entity.Address;
import uz.pdp.appjparelationships.entity.Faculty;

import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
    boolean existsByNameAndUniversityId(String name, Integer universityId);

    //ozimni universitetimni facultetlari listi kelishi km uning uchun jpa query yozmiz
    List<Faculty> findAllByUniversityId(Integer university_id);//shu jpa query
    //select * from faculty where univer_id

    boolean existsByUniversityId(Integer university_id);
}
