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
        return medicalRecords;
    }

    public List<String> birthdateList(){
        List<MedicalRecord> medicalRecords = dataHandler.getData().getMedicalrecords();
        List<String> birthdates= new ArrayList<>();
        for (MedicalRecord medicalRecord : medicalRecords){
            birthdates.add(medicalRecord.getBirthdate());
        }
        return birthdates;
    }

    public MedicalRecord postMedicalRecord(MedicalRecord medicalRecord){
        medicalRecordList().add(new MedicalRecord(medicalRecord.getFirstName(),medicalRecord.getLastName(),medicalRecord.getBirthdate(),medicalRecord.getMedications(),medicalRecord.getAllergies()));
        return medicalRecord;
    }

    public MedicalRecord updateMedicalRecord(MedicalRecord medicalRecord, MedicalRecord newmedicalrecord){
        medicalRecord.setBirthdate(newmedicalrecord.getBirthdate());
        medicalRecord.setMedications(newmedicalrecord.getMedications());
        medicalRecord.setAllergies(newmedicalrecord.getAllergies());
        return medicalRecord;
    }
    public void deleteMedicalRecord(int index){
        medicalRecordList().remove(index);
    }
}
