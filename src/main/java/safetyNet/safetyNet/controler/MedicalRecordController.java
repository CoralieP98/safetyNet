package safetyNet.safetyNet.controler;

import org.springframework.web.bind.annotation.*;
import safetyNet.safetyNet.model.MedicalRecord;
import safetyNet.safetyNet.service.MedicalRecordService;

import java.util.List;

@RestController
@RequestMapping("safetyNet")
public class MedicalRecordController {
    public final MedicalRecordService medicalRecordService;

    public MedicalRecordController(MedicalRecordService medicalRecordService) {
        this.medicalRecordService = medicalRecordService;
    }


    @PostMapping("medicalRecord")
    public MedicalRecord addMedicalRecord(@RequestBody MedicalRecord medicalRecord){
        return medicalRecordService.postMedicalRecord(medicalRecord);
    }

    @GetMapping("medicalRecord")
    public List<MedicalRecord> getAllMedicalRecord(){
        return medicalRecordService.getAllMedicalRecord();
    }
    @PutMapping("medicalRecord")
    public MedicalRecord updateMedicalRecord(@RequestParam(name="firstName")String firstName,@RequestParam(name="lastName") String lastName,@RequestBody MedicalRecord medicalRecord){
        return medicalRecordService.updateMedicalRecord(firstName,lastName,medicalRecord);
    }
    @DeleteMapping("medicalRecord")
    public void deleteMedicalRecord(@RequestParam(name="firstName")String firstName,@RequestParam(name="lastName") String lastName) {
        medicalRecordService.deleteMedicalRecord(firstName, lastName);
    }
}
