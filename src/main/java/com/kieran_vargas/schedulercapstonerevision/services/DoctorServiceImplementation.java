package com.kieran_vargas.schedulercapstonerevision.services;

import java.util.List;

import com.kieran_vargas.schedulercapstonerevision.models.Appointment;
import com.kieran_vargas.schedulercapstonerevision.models.Doctor;
import com.kieran_vargas.schedulercapstonerevision.repository.DoctorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImplementation implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public DoctorServiceImplementation(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor findByEmail(String email) {
        return doctorRepository.findByEmail(email);
    }

    @Override
    public List<Appointment> getDoctorAppointments(long id) {
        Doctor doctor = new Doctor();
        return doctor.getAppointments();
    }

    @Override
    public Doctor save(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }
}
