package uz.pdp.appjparelationships.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

// Nurkulov Nodirbek 2/20/2022  7:57 AM
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne//Many group to ONE faculty
    private Faculty faculty;
//
//    @OneToMany//ONE group to MANY students
//    private List<Student> students;
}
