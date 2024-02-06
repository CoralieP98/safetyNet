package safetyNet.safetyNet;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import safetyNet.safetyNet.controler.MedicalRecordController;
import safetyNet.safetyNet.model.MedicalRecord;
import safetyNet.safetyNet.repository.MedicalRecordRepository;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class MedicalRecordControllerTest {

    @Autowired
    private MedicalRecordController medicalRecordController;

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    @Test
    public void addMedicalRecordTest(){
        List<MedicalRecord> medicalRecordList= medicalRecordRepository.medicalRecordList();
        int sizeStart = medicalRecordList.size();
        MedicalRecord newMedicalRecord= new MedicalRecord("Melissa","Meh","01/01/01", Collections.singletonList(""), Collections.singletonList(""));
        medicalRecordController.addMedicalRecord(newMedicalRecord);
        int sizeEnd = medicalRecordList.size();

        assertThat(sizeEnd).isGreaterThan(sizeStart);
    }

    @Test
    public void getAllMedicalRecordTest(){
        assertThat(medicalRecordController.getAllMedicalRecord()).isNotNull();
    }

    @Test
    public void updateMedicalRecordTest(){
        List<MedicalRecord> medicalRecordList= medicalRecordRepository.medicalRecordList();
        String firstName = "John";
        String lastName = "Boyd";

        MedicalRecord medicalRecord= new MedicalRecord("Melissa","Meh","01/01/01", Collections.singletonList(""), Collections.singletonList(""));

        assertThat(medicalRecordController.updateMedicalRecord(firstName,lastName,medicalRecord).getBirthdate().equals("01/01/01"));
    }

    @Test
    public void deleteMedicalRecordTest(){
        List<MedicalRecord> medicalRecordList= medicalRecordRepository.medicalRecordList();
        int sizeStart = medicalRecordList.size();
        medicalRecordController.deleteMedicalRecord("John","Boyd");

        int sizeEnd = medicalRecordList.size();

        assertThat(sizeStart).isGreaterThan(sizeEnd);
    }

}
