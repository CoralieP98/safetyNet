package safetyNet.safetyNet.service.DTO;

import java.util.List;

public class ChildAlertDTO {

    private String firstName;

    private String lastName;
    private String age;

    List<String> sharingHouseholdWith;

    public ChildAlertDTO(String firstName, String lastName, String age, List<String> sharingHouseholdWith) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sharingHouseholdWith = sharingHouseholdWith;
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

    public List<String> getSharingHouseholdWith() {
        return sharingHouseholdWith;
    }

    public void setSharingHouseholdWith(List<String> sharingHouseholdWith) {
        this.sharingHouseholdWith = sharingHouseholdWith;
    }
}
