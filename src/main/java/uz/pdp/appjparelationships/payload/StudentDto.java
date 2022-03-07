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

//    {"firstName":"Lazizbek",
//            "city":"Karshi",
//            "district":"Koson",
//            "street":"Nasaf",
//            "groupName":"B1",
//            "groupId":1,
//            "facultyId":1
//    }
}
