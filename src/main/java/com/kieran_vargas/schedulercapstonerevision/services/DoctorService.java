package com.kieran_vargas.schedulercapstonerevision.services;

import java.util.List;

import com.kieran_vargas.schedulercapstonerevision.dtos.UserRegistrationDto;
import com.kieran_vargas.schedulercapstonerevision.models.Appointment;
import com.kieran_vargas.schedulercapstonerevision.models.Doctor;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface DoctorService extends UserDetailsService {

    List<Appointment> getDoctorAppointments(long id);

    Appointment getAppointmentById(long id);

    Doctor findByEmail(String email);

    Doctor save(UserRegistrationDto registration);

}
