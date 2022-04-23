package com.kieran_vargas.schedulercapstonerevision.services;

import java.util.ArrayList;
import java.util.List;

import com.kieran_vargas.schedulercapstonerevision.models.Appointment;
import com.kieran_vargas.schedulercapstonerevision.models.Patient;
//import com.kieran_vargas.schedulercapstonerevision.repository.PatientRepository;

import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PatientServiceImplementationTest {

    @Autowired
    private PatientService patientService;

    // private PatientRepository patientRepository;

    @Test
    void testGetAllPatients() {
        List<Patient> allPatients = patientService.getAllPatients();
        int amountPatientsBeforeAddingPatient = allPatients.size();
        Patient testPatient = new Patient(999999, "Testcase", "One", "test@patient.com", "480-254-2011", "Test Address",
                new ArrayList<Appointment>());
        patientService.save(testPatient);
        int amountPatientsAfterAddingPatient = patientService.getAllPatients().size();

        Assertions.assertThat(amountPatientsAfterAddingPatient).isEqualTo(amountPatientsBeforeAddingPatient + 1);
        Assertions.assertThat(allPatients.contains(testPatient));
    }

    @Test
    void testSave() {
        List<Patient> allPatients = patientService.getAllPatients();
        int amountPatientsBeforeAddingPatient = allPatients.size();
        Patient testPatient = new Patient(999999, "Testcase", "One", "test@patient.com", "480-254-2011", "Test Address",
                new ArrayList<Appointment>());
        patientService.save(testPatient);
        int amountPatientsAfterAddingPatient = patientService.getAllPatients().size();

        Assertions.assertThat(amountPatientsAfterAddingPatient).isEqualTo(amountPatientsBeforeAddingPatient + 1);
        Assertions.assertThat(allPatients.contains(testPatient));

    }

    @Test
    void testFindByEmail() {
        List<Patient> allPatients = patientService.getAllPatients();
        Patient testPatient = patientService.findByEmail("testpatient01@development.com");
        if (testPatient != null) {
            Patient testPatientInRepo = allPatients.get(0);
            Assertions.assertThat(testPatient.equals(testPatientInRepo));
        }

    }

    // @AfterAll
    // void cleanUpPatientTests() {
    // Patient testPatient = patientRepository.findByEmail("test@doctor.com");
    // patientRepository.delete(testPatient);
    // }
}
