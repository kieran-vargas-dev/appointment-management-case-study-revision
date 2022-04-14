package com.kieran_vargas.schedulercapstonerevision.services;

import java.util.List;

import com.kieran_vargas.schedulercapstonerevision.dtos.UserRegistrationDto;
import com.kieran_vargas.schedulercapstonerevision.models.Appointment;
import com.kieran_vargas.schedulercapstonerevision.models.Patient;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface PatientService extends UserDetailsService {

    List<Appointment> getPatientAppointments(long id);

    Appointment getAppointmentById(long id);

    Patient findByEmail(String email);

    Patient save(UserRegistrationDto registration);
}
