package safetyNet.safetyNet.repository;

import org.springframework.stereotype.Repository;
import safetyNet.safetyNet.Config.DataHandler;
import safetyNet.safetyNet.model.Data;
import safetyNet.safetyNet.model.Person;

import java.util.ArrayList;
import java.util.List;

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
}
