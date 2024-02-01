package safetyNet.safetyNet.service;

import org.springframework.stereotype.Service;
import safetyNet.safetyNet.model.MedicalRecord;
import safetyNet.safetyNet.model.Person;
import safetyNet.safetyNet.repository.MedicalRecordRepository;
import safetyNet.safetyNet.repository.PersonRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ChildAlertService {

    public final MedicalRecordRepository medicalRecordRepository;

    public final PersonRepository personRepository;


    public ChildAlertService(MedicalRecordRepository medicalRecordRepository, PersonRepository personRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
        this.personRepository = personRepository;
    }

    public List<String> calculateAge(){
//        medicalRecordRepository.birthdateList();
        List<Person> personList= personRepository.personList();
        List<MedicalRecord> medicalRecordList = medicalRecordRepository.medicalRecordList();
        LocalDate curDate = LocalDate.now();
        DateTimeFormatter formatIn = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter formatout = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (Person person:personList) {
            for (MedicalRecord medicalRecord:medicalRecordList) {


            }

        }
    }


}

//    Calendar c = Calendar.getInstance ();
//c.setLenient (false);
//        c.setTime (new Date (maintenant.getTimeInMillis () - cal.getTimeInMillis ()));



/*private int calculAge(int jour, int mois, int annee){
        GregorianCalendar now= new GregorianCalendar();
        GregorianCalendar d = new GregorianCalendar(annee,mois,jour);
        int age = now.get(Calendar.YEAR)-d.get(Calendar.YEAR);
        return age;
        }*/