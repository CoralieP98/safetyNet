package safetyNet.safetyNet.service.DTO;

import org.springframework.stereotype.Component;
import safetyNet.safetyNet.model.Person;

import java.util.List;

@Component
public class FireDTO {
    private String station;

    private List<PersonFireDTO> persons;


    public FireDTO() {
    }

    public FireDTO(List<PersonFireDTO> persons, String station) {
        this.persons = persons;
        this.station = station;
    }

    public List<PersonFireDTO> getPersons() {
        return persons;
    }

    public void setPersons(List<PersonFireDTO> persons) {
        this.persons = persons;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }
}
