package safetyNet.safetyNet.service;

import org.springframework.stereotype.Service;
import safetyNet.safetyNet.model.MedicalRecord;
import safetyNet.safetyNet.model.Person;
import safetyNet.safetyNet.repository.MedicalRecordRepository;
import safetyNet.safetyNet.repository.PersonRepository;
import safetyNet.safetyNet.service.DTO.ChildAlertDTO;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChildAlertService {

    public ChildAlertDTO childAlertDTO= new ChildAlertDTO();

    public final MedicalRecordRepository medicalRecordRepository;

    public final PersonRepository personRepository;


    public ChildAlertService(MedicalRecordRepository medicalRecordRepository, PersonRepository personRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
        this.personRepository = personRepository;
    }

    public Integer calculateAge(String birthdate){

        LocalDate curDate = LocalDate.now();
        DateTimeFormatter formatIn = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter formatout = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(birthdate, formatIn);
        date.format(formatout);

       return Period.between(date,curDate).getYears();
    }

    public List<ChildAlertDTO> childAlertList(String address) throws ParseException {
        List<ChildAlertDTO> childList =new ArrayList<>();
        List<MedicalRecord> medicalRecordList = medicalRecordRepository.medicalRecordList();
        List<Person> personList = personRepository.personList();

        for (Person person : personList){
            for(MedicalRecord medicalRecord : medicalRecordList){
                if (person.getFirstName().equals(medicalRecord.getFirstName())
                        && person.getLastName().equals(medicalRecord.getLastName())
                        && person.getAddress().equals(address)){
                    Integer age = calculateAge(medicalRecord.getBirthdate());
                    if (age <= 18){
                        List<Person> sharingHouseholdWith =new ArrayList<>();
                        for (Person people : personList){
                            if (person.getAddress().equals(people.getAddress())){
                                sharingHouseholdWith.add(people);
                            }
                        }
                        ChildAlertDTO childAlertDTO = new ChildAlertDTO();
                        childAlertDTO.setAge(age.toString());
                        childAlertDTO.setFirstName(person.getFirstName());
                        childAlertDTO.setLastName(person.getLastName());
                        childAlertDTO.setSharingHouseholdWith(sharingHouseholdWith);
                        childList.add(childAlertDTO);
                    }
                }
            }
        }
        return childList;
    }



}

