package safetyNet.safetyNet;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import safetyNet.safetyNet.controler.ChildAlertController;
import safetyNet.safetyNet.controler.PersonController;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ChildAlertControllerTest {

    @Autowired
    private ChildAlertController childAlertController;

    @Test
    public void childAlertTest() throws ParseException {
        assertThat(childAlertController.childAlert("1509 Culver St")).isNotNull();
    }


}
