package com.kieran_vargas.schedulercapstonerevision.services;

import java.util.List;

import com.kieran_vargas.schedulercapstonerevision.models.Appointment;
import com.kieran_vargas.schedulercapstonerevision.models.Patient;

public interface PatientService {

    List<Patient> getAllPatients();

    List<Appointment> getPatientAppointments(long id);

    Patient findByEmail(String email);

    Patient save(Patient patient);
}
