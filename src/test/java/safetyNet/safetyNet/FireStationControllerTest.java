package safetyNet.safetyNet;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import safetyNet.safetyNet.controler.FireStationController;
import safetyNet.safetyNet.model.FireStation;
import safetyNet.safetyNet.repository.FireStationRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
public class FireStationControllerTest {

    @Autowired
    private FireStationController fireStationController;

    @Autowired
    private FireStationRepository fireStationRepository;

    @Test
    public void createFireStationTest(){
        List<FireStation> fireStationList= fireStationRepository.fireStationList();
        int sizeStart = fireStationList.size();
        FireStation newFireStation= new FireStation("Mehland","5");

        fireStationController.createFireStation(newFireStation);
        int sizeEnd= fireStationList.size();

        assertThat(sizeEnd).isGreaterThan(sizeStart);
    }

    @Test
    public void fireStationListTest(){
        assertThat(fireStationController.fireStationList()).isNotNull();
    }

    @Test
    public void updateFireStationTest(){
        List<FireStation> fireStationList= fireStationRepository.fireStationList();
        String address = "1509 Culver St";
        FireStation fireStation = new FireStation("Meh","1");
        assertThat(fireStationController.updateFireStation(address, fireStation).getStation().equals("5"));
    }

    @Test
    public void deleteFireStationTest(){
        List<FireStation> fireStationList= fireStationRepository.fireStationList();
        int sizeStart = fireStationList.size();

        fireStationController.deleteFireStation("1509 Culver St");

        int sizeEnd= fireStationList.size();

        assertThat(sizeStart).isGreaterThan(sizeEnd);
    }




}
