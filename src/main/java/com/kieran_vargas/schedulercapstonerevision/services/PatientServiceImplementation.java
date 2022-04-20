package com.kieran_vargas.schedulercapstonerevision.services;

import java.util.List;

import com.kieran_vargas.schedulercapstonerevision.models.Appointment;
import com.kieran_vargas.schedulercapstonerevision.models.Patient;
import com.kieran_vargas.schedulercapstonerevision.repository.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImplementation implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public PatientServiceImplementation(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient findByEmail(String email) {
        return patientRepository.findByEmail(email);
    }

    @Override
    public List<Appointment> getPatientAppointments(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Appointment getAppointmentById(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }
}