package safetyNet.safetyNet.service.DTO;

import org.springframework.stereotype.Component;
import safetyNet.safetyNet.model.Person;

import java.util.List;
@Component
public class ChildAlertDTO {

    private String firstName;

    private String lastName;
    private String age;

    List<Person> sharingHouseholdWith;

    public ChildAlertDTO() {
    }

    public ChildAlertDTO(String firstName, String lastName, String age, List<Person> sharingHouseholdWith) {
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

    public List<Person> getSharingHouseholdWith() {
        return sharingHouseholdWith;
    }

    public void setSharingHouseholdWith(List<Person> sharingHouseholdWith) {
        this.sharingHouseholdWith = sharingHouseholdWith;
    }
}
