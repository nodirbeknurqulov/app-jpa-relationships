package uz.pdp.appjparelationships.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// Nurkulov Nodirbek 2/20/2022  7:38 AM

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;//1

    @Column(nullable = false)
    private String city;//Tashkent

    @Column(nullable = false)
    private String district;//Mirobod

    @Column(nullable = false)
    private String street;//U.Nosir ko'chasi
}
