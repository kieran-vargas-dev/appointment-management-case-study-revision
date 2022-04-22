package com.kieran_vargas.schedulercapstonerevision.services;

import java.util.ArrayList;
import java.util.List;

import com.kieran_vargas.schedulercapstonerevision.models.Appointment;
import com.kieran_vargas.schedulercapstonerevision.models.Doctor;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DoctorServiceImplementationTest {

    @Autowired
    private DoctorService doctorService;

    // @BeforeEach
    // Doctor createTestDoctor() {
    // Doctor testDoctor = new Doctor(999999, "Testcase", "One", "test@doctor.com",
    // "480-254-2011", "Test Address",
    // new ArrayList<Appointment>());
    // return testDoctor;
    // }

    @Test
    void testFindByEmail() {
        List<Doctor> allDoctors = doctorService.getAllDoctors();
        Doctor testDoctor = doctorService.findByEmail("testdoctor01@development.com");
        if (testDoctor != null) {
            Doctor testDoctorInRepo = allDoctors.get(0);
            Assertions.assertThat(testDoctor.equals(testDoctorInRepo));
        }
    }

    @Test
    void testGetAllDoctors() {
        DoctorService doctorService = this.doctorService;
        List<Doctor> allDoctors = doctorService.getAllDoctors();
        int amountDoctorsBeforeAddingDoctor = allDoctors.size();
        Doctor testDoctor = new Doctor(999999, "Testcase", "One", "test@doctor.com", "480-254-2011", "Test Address",
                new ArrayList<Appointment>());
        doctorService.save(testDoctor);
        int amountDoctorsAfterAddingDoctor = doctorService.getAllDoctors().size();

        Assertions.assertThat(amountDoctorsAfterAddingDoctor).isEqualTo(amountDoctorsBeforeAddingDoctor + 1);
        Assertions.assertThat(allDoctors.contains(testDoctor));
    }

    @Test
    void testGetDoctorAppointments() {

    }

    @Test
    void testSave() {
        DoctorService doctorService = this.doctorService;
        List<Doctor> allDoctors = doctorService.getAllDoctors();
        int amountDoctorsBeforeAddingDoctor = allDoctors.size();
        Doctor testDoctor = new Doctor(999999, "Testcase", "One", "test@doctor.com", "480-254-2011", "Test Address",
                new ArrayList<Appointment>());
        doctorService.save(testDoctor);
        int amountDoctorsAfterAddingDoctor = doctorService.getAllDoctors().size();

        Assertions.assertThat(amountDoctorsAfterAddingDoctor).isEqualTo(amountDoctorsBeforeAddingDoctor + 1);
        Assertions.assertThat(allDoctors.contains(testDoctor));
    }
}
