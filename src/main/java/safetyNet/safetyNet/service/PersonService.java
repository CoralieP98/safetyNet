package safetyNet.safetyNet.service;

import org.springframework.stereotype.Service;
import safetyNet.safetyNet.model.Data;
import safetyNet.safetyNet.repository.PersonRepository;

import java.util.List;

@Service
public class PersonService {

    public final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<String> getEmails(){
        return personRepository.getEmails();
    }
}
