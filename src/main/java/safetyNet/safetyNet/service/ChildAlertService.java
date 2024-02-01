package safetyNet.safetyNet.service;

import org.springframework.stereotype.Service;
import safetyNet.safetyNet.repository.MedicalRecordRepository;
import safetyNet.safetyNet.repository.PersonRepository;
@Service
public class ChildAlertService {

    public final MedicalRecordRepository medicalRecordRepository;

    public final PersonRepository personRepository;


    public ChildAlertService(MedicalRecordRepository medicalRecordRepository, PersonRepository personRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
        this.personRepository = personRepository;
    }


}
