package safetyNet.safetyNet.service;

import org.springframework.stereotype.Service;
import safetyNet.safetyNet.model.FireStation;
import safetyNet.safetyNet.repository.FireStationRepository;

import java.util.List;

@Service
public class FireStationService {

    public final FireStationRepository fireStationRepository;

    public FireStationService(FireStationRepository fireStationRepository) {
        this.fireStationRepository = fireStationRepository;
    }

    public FireStation createFireStation(FireStation fireStation){
        return fireStationRepository.createFireStation(fireStation);
    }

    public List<FireStation> getFireStations(){
        return fireStationRepository.fireStationList();
    }

    public FireStation updateFireStation(String address, FireStation newFireStation){
        for (FireStation fireStation: fireStationRepository.fireStationList()){
            if (fireStation.getAddress().equals(address)){
                fireStationRepository.updateFireStation(fireStation, newFireStation);
            }
        }
        return newFireStation;
    }

    public void deleteFireStation(String address){
        int index = 0;
        for (FireStation fireStation: fireStationRepository.fireStationList()){
            if (fireStation.getAddress().equals(address)){
                fireStationRepository.deleteFireStation(index);
                break;
            }
            index++;
        }
    }
}
