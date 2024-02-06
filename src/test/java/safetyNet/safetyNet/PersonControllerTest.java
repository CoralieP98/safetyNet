package safetyNet.safetyNet;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import safetyNet.safetyNet.Config.DataHandler;
import safetyNet.safetyNet.controler.PersonController;
import safetyNet.safetyNet.model.Person;
import safetyNet.safetyNet.repository.PersonRepository;
import safetyNet.safetyNet.service.PersonService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class PersonControllerTest {
    @Autowired
    private PersonController personController;

    @Test
    public void getEmailTest(){
    List<String> emails= personController.getEmails();;

    assertThat(emails).isNotNull();
    }

    @Test
    public void phoneAlertTest(){
        String station="1";
        List<String> phoneAlertList= personController.phoneAlert("2");

        assertNotEquals(phoneAlertList, personController.phoneAlert(station));
    }

    @Test
    public void personByStationTest(){
        assertThat(personController.personByStation("1")).isNotNull();
    }

    @Test
    public void personInfoListTest(){
        assertThat(personController.personInfoList("John","Boyd")).isNotNull();
    }

    @Test
    public void fireListTest(){
        assertThat(personController.fireList("1509 Culver St")).isNotNull();
    }

    @Test
    public void floodListTest(){
        assertThat(personController.floodList(new ArrayList<String>(){{add("1");add("2");}})).isNotNull();
    }




}
