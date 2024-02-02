package safetyNet.safetyNet.controler;

import org.springframework.web.bind.annotation.*;
import safetyNet.safetyNet.service.DTO.PersonByStationDTO;
import safetyNet.safetyNet.service.DTO.StationNumberDTO;
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

    /*@GetMapping("getAddressPerson")
    public List<String> listAdressPerson(){
        return personService.listAdressPerson();
    }*/
}
