package uz.pdp.appjparelationships.controller;

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appjparelationships.entity.Faculty;
import uz.pdp.appjparelationships.entity.University;
import uz.pdp.appjparelationships.payload.FacultyDto;
import uz.pdp.appjparelationships.repository.FacultyRepository;
import uz.pdp.appjparelationships.repository.UniversityRepository;

import java.util.List;
import java.util.Optional;

// Nurkulov Nodirbek 3/2/2022  2:56 PM

@RestController
@RequestMapping(value = "/faculty")
public class FacultyController {

    @Autowired
    FacultyRepository facultyRepository;

    @Autowired
    UniversityRepository universityRepository;

    //VAZIRLIK UCHUN U HAMMA FACULTETLARNI KOORA OLSIN

    //READ
    @GetMapping
    List<Faculty> getFaculties() {
        return facultyRepository.findAll();
    }

    //CREATE
    @PostMapping
    public String addFaculty(@RequestBody FacultyDto facultyDto) {
        boolean exists = facultyRepository.existsByNameAndUniversityId(facultyDto.getName(), facultyDto.getUniversityId());
        if (exists)
            return "This university has such kind of faculty";
        Faculty faculty = new Faculty();
        faculty.setName(facultyDto.getName());

        Optional<University> optionalUniversity = universityRepository.findById(facultyDto.getUniversityId());
        if (!optionalUniversity.isPresent())
            return "University not found";
        faculty.setUniversity(optionalUniversity.get());
        facultyRepository.save(faculty);
        return "Faculty saved";
    }

    //UPDATE
    @PutMapping("/{id}")
    public String updateFaculty(@PathVariable Integer id, @RequestBody FacultyDto facultyDto) {
        Optional<Faculty> optionalFaculty = facultyRepository.findById(id);
        if (optionalFaculty.isPresent()) {
            Faculty faculty = optionalFaculty.get();
            faculty.setName(facultyDto.getName());
            Optional<University> optionalUniversity = universityRepository.findById(facultyDto.getUniversityId());
            if (optionalUniversity.isPresent()) {
                University university = optionalUniversity.get();
                faculty.setUniversity(university);
            } else {
                return "University not found";
            }
            facultyRepository.save(faculty);
            return "Faculty updated";
        }
        return "Faculty not found";
    }

    //DELETE
    @DeleteMapping("/{id}")
    public String deleteFaculty(@PathVariable Integer id) {
//        Optional<Faculty> optionalFaculty = facultyRepository.findById(id);
//        if (optionalFaculty.isPresent()){
//            Faculty faculty = optionalFaculty.get();
//            facultyRepository.delete(faculty);
//            return "Faculty deleted!!!";
//        }else {
//            return "Faculty not found";
//        }
        try {
            facultyRepository.deleteById(id);
            return "Faculty deleted!!!";
        } catch (Exception a) {
            return "Error in deleting!";
        }
    }

    //UNIVERSITET HODIMI UCHUN
    @GetMapping("/byUniversityId/{universityId}")
    public List<Faculty> getFacultiesByUniversityId(@PathVariable Integer universityId) {
        List<Faculty> allByUniversityId = facultyRepository.findAllByUniversityId(universityId);
        return allByUniversityId;
    }
}
