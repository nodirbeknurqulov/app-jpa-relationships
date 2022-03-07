package uz.pdp.appjparelationships.controller;

// Nurkulov Nodirbek 3/2/2022  7:28 AM

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appjparelationships.entity.Subject;
import uz.pdp.appjparelationships.repository.SubjectRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    SubjectRepository subjectRepository;

    //CREATE
    @RequestMapping(method = RequestMethod.POST)
    public String addSubject(@RequestBody Subject subject) {
        boolean existByName = subjectRepository.existsByName(subject.getName());
        if (existByName)
            return "This subject is already exist";
        subjectRepository.save(subject);
        return "Subject added";
    }

    //READ
    @GetMapping
    public List<Subject> getSubjects() {
        List<Subject> subjectList = subjectRepository.findAll();
        return subjectList;
    }

    //UPDATE
    @PutMapping("/{id}")
    public String updateSubject(@PathVariable Integer id,@RequestBody Subject subject){
        Optional<Subject> optionalSubjectId = subjectRepository.findById(id);

        if (optionalSubjectId.isPresent()) {
            Subject subject2 = optionalSubjectId.get();

          subject2.setName(subject.getName());
          subjectRepository.save(subject2);
          return "Successfully updated";
        }
        return "Subject not found";
    }

    //DELETE TODO
    @DeleteMapping("/{id}")
    public String deleteSubject(@PathVariable Integer id){
        Optional<Subject> optionalSubjectId = subjectRepository.findById(id);
        if (optionalSubjectId.isPresent()){
            Subject subject = optionalSubjectId.get();
            subjectRepository.delete(subject);
            return "Subject deleted!";
        }
        return "Subject not found";
    }

}
