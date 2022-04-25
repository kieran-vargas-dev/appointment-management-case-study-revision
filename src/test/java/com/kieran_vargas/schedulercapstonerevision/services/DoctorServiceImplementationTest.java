package com.kieran_vargas.schedulercapstonerevision.services;

import java.util.ArrayList;
import java.util.List;

import com.kieran_vargas.schedulercapstonerevision.models.Appointment;
import com.kieran_vargas.schedulercapstonerevision.models.Doctor;
import com.kieran_vargas.schedulercapstonerevision.repository.DoctorRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DoctorServiceImplementationTest {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private DoctorRepository doctorRepository;

    @Test
    void testGetAllDoctors() {
        List<Doctor> allDoctors = doctorService.getAllDoctors();
        int amountDoctorsBeforeAddingDoctor = allDoctors.size();
        Doctor testDoctor = new Doctor(999998, "Testcase", "One", "test@doctor.com", "480-254-2011", "Test Address",
                new ArrayList<Appointment>());
        doctorService.save(testDoctor);
        int amountDoctorsAfterAddingDoctor = doctorService.getAllDoctors().size();

        Assertions.assertThat(amountDoctorsAfterAddingDoctor).isEqualTo(amountDoctorsBeforeAddingDoctor + 1);
        Assertions.assertThat(allDoctors.contains(testDoctor));
    }

    @Test
    void testSave() {
        List<Doctor> allDoctors = doctorService.getAllDoctors();
        int amountDoctorsBeforeAddingDoctor = allDoctors.size();
        Doctor testDoctor = new Doctor(999999, "Testcase", "Two", "test2@doctor.com", "480-254-2011", "Test Address",
                new ArrayList<Appointment>());
        doctorService.save(testDoctor);
        int amountDoctorsAfterAddingDoctor = doctorService.getAllDoctors().size();

        Assertions.assertThat(amountDoctorsAfterAddingDoctor).isEqualTo(amountDoctorsBeforeAddingDoctor + 1);
        Assertions.assertThat(allDoctors.contains(testDoctor));
    }

    @Test
    void testFindByEmail() {
        List<Doctor> allDoctors = doctorService.getAllDoctors();
        Doctor testDoctor = doctorService.findByEmail("test@doctor.com");
        if (testDoctor != null) {
            Doctor testDoctorInRepo = allDoctors.get(0);
            Assertions.assertThat(testDoctor.equals(testDoctorInRepo));
        }
    }

    @AfterAll
    void cleanUpDoctorTests() {
        Doctor testDoctor = doctorRepository.findByEmail("test@doctor.com");
        Doctor testDoctor2 = doctorRepository.findByEmail("test2@doctor.com");
        doctorRepository.delete(testDoctor);
        doctorRepository.delete(testDoctor2);
    }

}
