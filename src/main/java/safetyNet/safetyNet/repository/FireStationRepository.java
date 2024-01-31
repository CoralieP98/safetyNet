package safetyNet.safetyNet.repository;

import org.springframework.stereotype.Repository;
import safetyNet.safetyNet.Config.DataHandler;
import safetyNet.safetyNet.model.FireStation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class FireStationRepository {

    public final DataHandler dataHandler;

    public FireStationRepository(DataHandler dataHandler) {
        this.dataHandler = dataHandler;
    }

    public List<String> listAddressFireStation(){
        List<FireStation> fireStations = dataHandler.getData().getFirestations();
        List<FireStation> adresses = fireStations.stream().filter(adress -> adress.getAddress() != null).collect(Collectors.toList());
        List<String> fireStationList = new ArrayList<>();

        for(FireStation fireStation: adresses){
            fireStationList.add(fireStation.getAddress());
        }
        return fireStationList;
    }
}
