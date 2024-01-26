package safetyNet.safetyNet.model;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class MedicalRecord {

    private String firstName;
    private String lastName;
    private DateFormat birthdate;
    List<String> medications;
    List<String> allergies;

    public MedicalRecord(){}

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

    public DateFormat getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(DateFormat birthdate) {
        this.birthdate = birthdate;
    }

    public List<String> getMedications() {
        return medications;
    }

    public void setMedications(List<String> medications) {
        this.medications = medications;
    }

    public List<String> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }
}
