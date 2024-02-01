package safetyNet.safetyNet.repository;

import org.springframework.stereotype.Repository;
import safetyNet.safetyNet.Config.DataHandler;
import safetyNet.safetyNet.model.MedicalRecord;

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
}
