package safetyNet.safetyNet.service.DTO;

import java.util.List;

public class ChildAlertDTO {

    private String firstName;

    private String lastName;
    private String age;

    List<String> sharingHouseHoldWith;

    public ChildAlertDTO(String firstName, String lastName, String age, List<String> sharingHouseHoldWith) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sharingHouseHoldWith = sharingHouseHoldWith;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public List<String> getSharingHouseHoldWith() {
        return sharingHouseHoldWith;
    }

    public void setSharingHouseHoldWith(List<String> sharingHouseHoldWith) {
        this.sharingHouseHoldWith = sharingHouseHoldWith;
    }
}
