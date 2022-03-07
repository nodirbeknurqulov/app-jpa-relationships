package uz.pdp.appjparelationships.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Nurkulov Nodirbek 2/20/2022  10:38 AM
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UniversityDto {//MA'LUMOTLARNI TASHISH UCHUN XIZMAT QILADI
    private String name;
    private String city;
    private String district;
    private String street;
}
