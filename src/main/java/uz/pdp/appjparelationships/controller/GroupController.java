package uz.pdp.appjparelationships.controller;

// Nurkulov Nodirbek 3/2/2022  5:12 PM

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appjparelationships.entity.Faculty;
import uz.pdp.appjparelationships.entity.Group;
import uz.pdp.appjparelationships.payload.GroupDto;
import uz.pdp.appjparelationships.repository.FacultyRepository;
import uz.pdp.appjparelationships.repository.GroupRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    FacultyRepository facultyRepository;

    //READ
    //VAZRLIK UCHUN
    @GetMapping
    public List<Group> getGroups() {
        List<Group> groups = groupRepository.findAll();
        return groups;
    }

    //UNIVERSITETNI MAS'UL HODIMI
    @GetMapping("/byUniversityId/{universityId}")
    public List<Group> getGroupsByUniversityId(@PathVariable Integer universityId) {
        //UNIGA FAQATGINA OZINI UNIVERSITETINI  GURUHLARINI BERISHIMIZ KK
        List<Group> allByFaculty_university_id = groupRepository.findAllByFaculty_University_Id(universityId);
        List<Group> groupsByUniversityId = groupRepository.getGroupsByUniversityId(universityId);
        List<Group> groupsByUniversityIdNative = groupRepository.getGroupsByUniversityIdNative(universityId);
        //3 chalasi ham bir xil join qilib ishlaydi
        return allByFaculty_university_id;
    }

    //CREATE GROUP
    //endi bu yerga gruhlarni qoshadiga method yozishimiz kk
    @PostMapping
    public String addGroup(@RequestBody GroupDto groupDto) {

        Group group = new Group();
        group.setName(groupDto.getName());
        Optional<Faculty> optionalFaculty = facultyRepository.findById(groupDto.getFacultyId());
        if (!optionalFaculty.isPresent()){
            return "This faculty not found";
        }
        group.setFaculty(optionalFaculty.get());
        groupRepository.save(group);
        return "Group added!!!";
    }

    // TODO: 3/5/2022 update, delete group
    // TODO: 3/5/2022 Sirojiddin aka yuqoridagidan tashqari studentlarni ham CRUD
    //  ini qilishni uyga vazifa qilib berdi
    // TODO: 3/5/2022 CRUD(STUDENT)

    //UPDATE GROUP

    //DELETE GROUP


}
