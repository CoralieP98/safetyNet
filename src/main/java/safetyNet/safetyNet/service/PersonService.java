package safetyNet.safetyNet.service;

import org.springframework.stereotype.Service;
import safetyNet.safetyNet.model.FireStation;
import safetyNet.safetyNet.model.MedicalRecord;
import safetyNet.safetyNet.model.Person;
import safetyNet.safetyNet.repository.FireStationRepository;
import safetyNet.safetyNet.repository.MedicalRecordRepository;
import safetyNet.safetyNet.repository.PersonRepository;
import safetyNet.safetyNet.service.DTO.PersonByStationDTO;
import safetyNet.safetyNet.service.DTO.StationNumberDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PersonService {

    public final StationNumberDTO stationNumberDTO;

    public final FireStationRepository fireStationRepository;

    public final PersonRepository personRepository;

    public final ChildAlertService childAlertService;
    public final MedicalRecordRepository medicalRecordRepository;

    public PersonService(StationNumberDTO stationNumberDTO, FireStationRepository fireStationRepository, PersonRepository personRepository, ChildAlertService childAlertService, MedicalRecordRepository medicalRecordRepository) {
        this.stationNumberDTO = stationNumberDTO;
        this.fireStationRepository = fireStationRepository;
        this.personRepository = personRepository;
        this.childAlertService = childAlertService;
        this.medicalRecordRepository = medicalRecordRepository;
    }

    public List<String> getEmails(){
        return personRepository.getEmails();
    }

    public List<String> phoneAlert(String station){
        List<FireStation> fireStationList = fireStationRepository.fireStationList();
        List<Person> personList = personRepository.personList();
        List<String> listPhoneNumber = new ArrayList<>();

        for (FireStation fireStation:fireStationList){
            if (Objects.equals(fireStation.getStation(), station)){
                for (Person person: personList){
                    if (Objects.equals(fireStation.getAddress(), person.getAddress())){
                        listPhoneNumber.add(person.getPhone());
                    }
                }
            }
        }
        return listPhoneNumber;
    }

    public StationNumberDTO stationNumber(String station){
        List<PersonByStationDTO> personByStationDTOList = new ArrayList<>();
        List<FireStation> fireStationList = fireStationRepository.fireStationList();
        List<MedicalRecord> medicalRecordList= medicalRecordRepository.medicalRecordList();
        List<Person> personList = personRepository.personList();

        for (FireStation fireStation: fireStationList) {
            if (fireStation.getStation().equals(station)){
                for (Person person: personList){
                    if (person.getAddress().equals(fireStation.getAddress())){
                        personByStationDTOList.add(new PersonByStationDTO
                                (person.getFirstName(),person.getLastName(),person.getAddress(),person.getPhone()));
                    }
                }
            }
        }
        Integer nbChild = 0;
        Integer nbAdult = 0;

        for (PersonByStationDTO person: personByStationDTOList) {
            for (MedicalRecord medicalRecord : medicalRecordList) {
                if (person.getFirstName().equals(medicalRecord.getFirstName())
                        && person.getLastName().equals(medicalRecord.getLastName()))
                {
                    Integer age = childAlertService.calculateAge(medicalRecord.getBirthdate());
                    if (age <= 18) {
                        nbChild ++;
                    } else {
                        nbAdult ++;
                    }
                }
            }
        }
        StationNumberDTO stationNumberDTO= new StationNumberDTO(nbChild,nbAdult,personByStationDTOList);
        return stationNumberDTO;

    }


    /*public List<String> listAdressPerson(){
        return personRepository.listAdressPerson();
    }

    public List<String> listAddressFireStation(){
        return fireStationRepository.listAddressFireStation();
    }

    public List<String> listCorespondingPhoneNumber(){
//        if (personRepository.listAdressPerson() = fireStationRepository.listAddressFireStation())
        List<String> listAdress = new ArrayList<>();
        if(listAdress.stream().anyMatch(adress -> listAdressPerson() == listAddressFireStation()));
    }*/
}
