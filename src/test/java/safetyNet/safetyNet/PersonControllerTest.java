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

    @Autowired
    private PersonRepository personRepository;

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

    @Test
    public void createPersonTest(){
        List<Person> personList= personRepository.personList();
        int sizeStart = personList.size();
        Person newPerson= new Person("Mehlissa","Meh","1 rue meh","Mehland","666","06+","meh@email.com");

        personController.createPerson(newPerson);
        int sizeEnd = personList.size();

        assertThat(sizeEnd).isGreaterThan(sizeStart);
    }

    @Test
    public void listPersonTest(){
        assertThat(personController.listPerson()).isNotNull();
    }

    @Test
    public void updatePersonTest(){
        List<Person> personList=personRepository.personList();
        String firstName = "John";
        String lastName = "Boyd";

        Person person = new Person("Mehlissa","Meh","1 rue meh","Mehland","666","06+","meh@email.com");
        assertThat(personController.updatePerson(firstName,lastName,person).getZip().equals("666"));

    }

    @Test
    public void deletePersonTest(){
        List<Person> personList= personRepository.personList();
        int sizeStart = personList.size();

        personController.deletePerson("John","Boyd");

        int sizeEnd = personList.size();

        assertThat(sizeStart).isGreaterThan(sizeEnd);
    }




}
