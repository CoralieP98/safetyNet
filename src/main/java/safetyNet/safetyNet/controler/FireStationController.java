package safetyNet.safetyNet.controler;

import org.springframework.web.bind.annotation.*;
import safetyNet.safetyNet.model.FireStation;
import safetyNet.safetyNet.service.FireStationService;

import java.util.List;

@RestController
@RequestMapping("safetyNet")
public class FireStationController {

    public final FireStationService fireStationService;

    public FireStationController(FireStationService fireStationService) {
        this.fireStationService = fireStationService;
    }

    @PostMapping("firestation")
    public FireStation createFireStation(@RequestBody FireStation fireStation){
        return fireStationService.createFireStation(fireStation);
    }

    @GetMapping("firestations")
    public List<FireStation> fireStationList(){
        return fireStationService.getFireStations();
    }

    @PutMapping("updateFS")
    public FireStation updateFireStation(@RequestParam(name="address")String address,@RequestBody FireStation fireStation){
        return fireStationService.updateFireStation(address, fireStation);
    }

    @DeleteMapping("deleteFS")
    public void deleteFireStation(@RequestParam(name="address")String address){
        fireStationService.deleteFireStation(address);

    }
}
