package com.kieran_vargas.schedulercapstonerevision.services;

import java.util.List;

import com.kieran_vargas.schedulercapstonerevision.models.Appointment;
import com.kieran_vargas.schedulercapstonerevision.models.Doctor;

public interface DoctorService {

    List<Doctor> getAllDoctors();

    List<Appointment> getDoctorAppointments(long id);

    Doctor findByEmail(String email);

    Doctor save(Doctor doctor);

}
