package safetyNet.safetyNet.controler;

import org.springframework.web.bind.annotation.*;
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

    /*@GetMapping("phoneAlert/{firestation}")
    public List<String> phoneAlert(@PathVariable("station") String station){
        return personService.phoneAlert(station);
    }*/

    //meh

    @GetMapping("phoneAlert")
    public List<String> phoneAlert(@RequestParam(name="firestation") String station){
        return personService.phoneAlert(station);
    }

    /*@GetMapping("getAddressPerson")
    public List<String> listAdressPerson(){
        return personService.listAdressPerson();
    }*/
}
