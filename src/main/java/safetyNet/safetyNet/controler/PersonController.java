package safetyNet.safetyNet.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import safetyNet.safetyNet.model.Person;
import safetyNet.safetyNet.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("safetyNet")
public class PersonController {

    public final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("getEmail")
    public List<String> getEmails(){

        return personService.getEmails();
    }

    @GetMapping("getAddressPerson")
    public List<String> listAdressPerson(){
        return personService.listAdressPerson();
    }
}
