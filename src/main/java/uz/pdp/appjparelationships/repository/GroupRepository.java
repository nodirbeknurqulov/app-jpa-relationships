package uz.pdp.appjparelationships.repository;
// Nurkulov Nodirbek 2/20/2022  10:49 AM

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.appjparelationships.entity.Address;
import uz.pdp.appjparelationships.entity.Group;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Integer> {
    //jpa ni ozida yozilga query
    List<Group> findAllByFaculty_University_Id(Integer faculty_university_id);

    //2-usuli
    @Query("select gr from groups gr where gr.faculty.university.id=:universityId")//ikkovi bir xil
    List<Group> getGroupsByUniversityId(Integer universityId);

    //3-usuli
    @Query(value = "select *\n" +
            "from groups g\n" +
            "         join faculty f on f.id = g.faculty_id\n" +
            "         join university u on u.id = f.university_id\n" +
            "where u.id=:universityId",nativeQuery = true)
    List<Group> getGroupsByUniversityIdNative(Integer universityId);

}
