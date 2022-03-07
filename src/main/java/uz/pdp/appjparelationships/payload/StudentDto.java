package uz.pdp.appjparelationships.payload;

import lombok.Data;

// Nurkulov Nodirbek 3/7/2022  10:23 AM
@Data
public class StudentDto {
    private String firstName;
    private String city;
    private String district;
    private String street;
    private String groupName;
    private Integer groupId;
    private Integer facultyId;
}
