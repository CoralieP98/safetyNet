package safetyNet.safetyNet.service;

import org.springframework.stereotype.Service;
import safetyNet.safetyNet.model.Data;
import safetyNet.safetyNet.model.FireStation;
import safetyNet.safetyNet.model.Person;
import safetyNet.safetyNet.repository.FireStationRepository;
import safetyNet.safetyNet.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PersonService {

    public final FireStationRepository fireStationRepository;

    public final PersonRepository personRepository;

    public PersonService(FireStationRepository fireStationRepository, PersonRepository personRepository) {
        this.fireStationRepository = fireStationRepository;
        this.personRepository = personRepository;
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
