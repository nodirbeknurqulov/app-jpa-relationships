package uz.pdp.appjparelationships.repository;

// Nurkulov Nodirbek 2/20/2022  10:49 AM

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appjparelationships.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Page<Student> findAllByGroup_Faculty_UniversityId(Integer group_faculty_university_id, Pageable pageable);
    Page<Student> findAllByGroup_FacultyId(Integer group_faculty_id, Pageable pageable);
    Page<Student> findAllByGroupId(Integer group_id, Pageable pageable);
}
