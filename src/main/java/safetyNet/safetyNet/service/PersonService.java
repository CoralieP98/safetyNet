package safetyNet.safetyNet.service;

import org.springframework.stereotype.Service;
import safetyNet.safetyNet.model.FireStation;
import safetyNet.safetyNet.model.MedicalRecord;
import safetyNet.safetyNet.model.Person;
import safetyNet.safetyNet.repository.FireStationRepository;
import safetyNet.safetyNet.repository.MedicalRecordRepository;
import safetyNet.safetyNet.repository.PersonRepository;
import safetyNet.safetyNet.service.DTO.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PersonService {

    public final StationNumberDTO stationNumberDTO;
    public final PersonInfoDTO personInfoDTO;
    public final FireDTO fireDTO;

    public final FireStationRepository fireStationRepository;

    public final PersonRepository personRepository;

    public final ChildAlertService childAlertService;
    public final MedicalRecordRepository medicalRecordRepository;

    public PersonService(StationNumberDTO stationNumberDTO, PersonInfoDTO personInfoDTO, FireDTO fireDTO, FireStationRepository fireStationRepository, PersonRepository personRepository, ChildAlertService childAlertService, MedicalRecordRepository medicalRecordRepository) {
        this.stationNumberDTO = stationNumberDTO;
        this.personInfoDTO = personInfoDTO;
        this.fireDTO = fireDTO;
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


    public List<PersonInfoDTO> personInfoList (String lastname){
        List<MedicalRecord> medicalRecordList= medicalRecordRepository.medicalRecordList();
        List<Person> personList = personRepository.personList();
        List<PersonInfoDTO> personInfoDTOList = new ArrayList<>();

        for (Person person: personList){
            if (person.getLastName().equals(lastname)){
                for (MedicalRecord medicalRecord: medicalRecordList){
                    if (person.getLastName().equals(medicalRecord.getLastName()) && person.getFirstName().equals(medicalRecord.getFirstName())){
                        Integer age = childAlertService.calculateAge(medicalRecord.getBirthdate());

                        personInfoDTOList.add(new PersonInfoDTO
                                (person.getLastName(), person.getAddress(),age,person.getEmail(),medicalRecord.getMedications(),medicalRecord.getAllergies()));
                    }
                }
            }
        }
       return personInfoDTOList;
    }


    public FireDTO fireList(String address){
        List<MedicalRecord> medicalRecordList= medicalRecordRepository.medicalRecordList();
        List<Person> personList = personRepository.personList();
        List<FireStation> fireStationList = fireStationRepository.fireStationList();


//        for (Person person : personList){
//            if (person.getAddress().equals(address)){
//                for (MedicalRecord medicalRecord: medicalRecordList){
//                    if (person.getLastName().equals(medicalRecord.getLastName()) && person.getFirstName().equals(medicalRecord.getFirstName())){
//                        Integer age = childAlertService.calculateAge(medicalRecord.getBirthdate());
//                        personFireDTOList.add(new PersonFireDTO
//                                (person.getLastName(),person.getPhone(),age,
//                                        medicalRecord.getMedications(),medicalRecord.getAllergies()));
//                    }
//                }
//            }
//        }
        List<PersonFireDTO> personFireDTOList=listPersonByAddress(address);

        String station="";
        for (FireStation fireStation: fireStationList){
            if (fireStation.getAddress().equals(address)){
                station = fireStation.getStation();
            }
        }
        return new FireDTO(personFireDTOList,station);
    }


    public List<FloodDTO> floodList(List<String> station){
        List<FloodDTO> floodDTOList=new ArrayList<>();
        List<MedicalRecord> medicalRecordList= medicalRecordRepository.medicalRecordList();
        List<Person> personList = personRepository.personList();
        List<FireStation> fireStationList = fireStationRepository.fireStationList();

        for (String stations: station){
//            FloodDTO floodDTO = new FloodDTO();
            List<PersonByAddressDTO> personByAddressDTOList = new ArrayList<>();

            for (FireStation fireStation:fireStationList){
                if (stations.equals(fireStation.getStation())){
                    List<PersonFireDTO> personFireDTOList=listPersonByAddress(fireStation.getAddress());
                    personByAddressDTOList.add(new PersonByAddressDTO(fireStation.getAddress(),personFireDTOList));
                }
            }
            floodDTOList.add(new FloodDTO(stations, personByAddressDTOList));
        }
        return floodDTOList;
    }



    public List<PersonFireDTO> listPersonByAddress(String address){
        List<MedicalRecord> medicalRecordList= medicalRecordRepository.medicalRecordList();
        List<Person> personList = personRepository.personList();
        List<PersonFireDTO> personFireDTOList=new ArrayList<>();

        for (Person person:personList){
            if (address.equals(person.getAddress())){
                for (MedicalRecord medicalRecord: medicalRecordList){
                    if (person.getLastName().equals(medicalRecord.getLastName()) && person.getFirstName().equals(medicalRecord.getFirstName())){
                        Integer age = childAlertService.calculateAge(medicalRecord.getBirthdate());
                        personFireDTOList.add(new PersonFireDTO
                                (person.getLastName(),person.getPhone(),age,
                                        medicalRecord.getMedications(),medicalRecord.getAllergies()));
                    }
                }
            }
        }
        return personFireDTOList;
    }



    public Person createPerson(Person person){
        return personRepository.createPerson(person);
    }

    public List<Person> getPersons(){
        return  personRepository.personList();
    }


    public Person updatePerson(String firstName,String lastName,Person person){
        for (Person person1 : personRepository.personList()){
            if (person1.getFirstName().equals(firstName) && person1.getLastName().equals(lastName)){
                personRepository.updatePerson(person1, person);
                break;
            }
        }
        return person;
    }

    public void deletePerson(String firstName,String lastName){
        int index=0;
        for (Person person: personRepository.personList()){
            if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)){
                personRepository.deletePerson(index);
                break;
            }
            index++;
        }
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
