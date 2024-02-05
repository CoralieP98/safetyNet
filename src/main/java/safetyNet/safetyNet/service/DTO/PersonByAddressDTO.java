package safetyNet.safetyNet.service.DTO;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonByAddressDTO {

    private String address;
    private List<PersonFireDTO> personAtAddress;

    public PersonByAddressDTO() {
    }

    public PersonByAddressDTO(String address, List<PersonFireDTO> personFireDTOList) {
        this.address = address;
        this.personAtAddress = personFireDTOList;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<PersonFireDTO> getPersonAtAddress() {
        return personAtAddress;
    }

    public void setPersonAtAddress(List<PersonFireDTO> personAtAddress) {
        this.personAtAddress = personAtAddress;
    }
}
