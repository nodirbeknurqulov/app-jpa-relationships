package uz.pdp.appjparelationships.entity;

import lombok.*;

import javax.persistence.*;

// Nurkulov Nodirbek 2/20/2022  8:32 AM

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToOne(optional = false)
    private Address address;
}
