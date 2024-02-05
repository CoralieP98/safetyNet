package safetyNet.safetyNet.controler;

import org.springframework.web.bind.annotation.*;
import safetyNet.safetyNet.model.Person;
import safetyNet.safetyNet.service.DTO.*;
import safetyNet.safetyNet.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("safetyNet")
public class PersonController {

    public final PersonService personService;

    public final PersonByStationDTO personByStationDTO;

    public final StationNumberDTO stationNumberDTO;

    public PersonController(PersonService personService, PersonByStationDTO personByStationDTO, StationNumberDTO stationNumberDTO) {
        this.personService = personService;
        this.personByStationDTO = personByStationDTO;
        this.stationNumberDTO = stationNumberDTO;
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

    @GetMapping("firestation")
    public StationNumberDTO  personByStation(@RequestParam(name="stationNumber") String station){
        return personService.stationNumber(station);
    }

    @GetMapping("personInfo")
    public List<PersonInfoDTO> personInfoList (@RequestParam(name="firstName")String firstName, @RequestParam(name="lastName") String lastName){
        return personService.personInfoList(lastName);
    }

    @GetMapping("fire")
    public FireDTO fireList (@RequestParam(name="address") String address){
        return personService.fireList(address);
    }

    @GetMapping("flood/stations")
    public List<FloodDTO> floodList(@RequestParam(name="stations")List<String> station){
        return personService.floodList(station);

    }

    @PostMapping("person")
    public Person createPerson(@RequestBody Person person){
       return personService.createPerson(person);
    }

    @GetMapping("person")
    public List<Person> listPerson(){
        return personService.getPersons();
    }

    @PutMapping("update")
    public Person updatePerson(@RequestParam(name="firstName")String firstName,@RequestParam(name="lastName")String lastName,@RequestBody Person person){
        return personService.updatePerson(firstName,lastName,person);
    }

    @DeleteMapping("delete")
    public void deletePerson(@RequestParam(name="firstName")String firstName,@RequestParam(name="lastName")String lastName){
        personService.deletePerson(firstName,lastName);
    }

    /*@GetMapping("getAddressPerson")
    public List<String> listAdressPerson(){
        return personService.listAdressPerson();
    }*/
}
