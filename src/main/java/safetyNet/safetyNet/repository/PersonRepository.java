package safetyNet.safetyNet.repository;

import com.jsoniter.spi.OmitValue;
import org.springframework.stereotype.Repository;
import safetyNet.safetyNet.Config.DataHandler;
import safetyNet.safetyNet.model.Data;
import safetyNet.safetyNet.model.FireStation;
import safetyNet.safetyNet.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonRepository {

    public final DataHandler dataHandler;


    public PersonRepository(DataHandler dataHandler) {
        this.dataHandler = dataHandler;
    }

    public List<String> getEmails() {
        List<Person> persons = dataHandler.getData().getPersons();
        List<String> emails = new ArrayList<>();
        for (Person person  :persons ){
          emails.add(  person.getEmail());
        }
        return emails;
    }


    public List<String> listAdressPerson(){
//        List<FireStation> firestations = dataHandler.getData().getFirestations();
        List<Person> persons = dataHandler.getData().getPersons();
        List<Person> adresses = persons.stream().filter(adress -> adress.getAddress() != null).collect(Collectors.toList());
        List<String> adressList = new ArrayList<>();

        for(Person person: adresses){
            adressList.add(person.getAddress());
        }
        return adressList;
    }
}
