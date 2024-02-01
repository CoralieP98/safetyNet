package safetyNet.safetyNet.repository;

import org.springframework.stereotype.Repository;
import safetyNet.safetyNet.Config.DataHandler;
import safetyNet.safetyNet.model.MedicalRecord;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MedicalRecordRepository {

    public final DataHandler dataHandler;

    public MedicalRecordRepository(DataHandler dataHandler) {
        this.dataHandler = dataHandler;
    }

    public List<MedicalRecord> medicalRecordList(){
        List<MedicalRecord> medicalRecords = dataHandler.getData().getMedicalrecords();
        return medicalRecordList();
    }

    public List<String> birthdateList(){
        List<MedicalRecord> medicalRecords = dataHandler.getData().getMedicalrecords();
        List<String> birthdates= new ArrayList<>();
        for (MedicalRecord medicalRecord : medicalRecords){
            birthdates.add(medicalRecord.getBirthdate());
        }
        return birthdates;


    }
}
