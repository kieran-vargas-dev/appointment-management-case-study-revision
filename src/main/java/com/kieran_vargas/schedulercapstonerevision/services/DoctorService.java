package com.kieran_vargas.schedulercapstonerevision.services;

import java.util.List;

import com.kieran_vargas.schedulercapstonerevision.models.Appointment;

public interface DoctorService {

    List<Appointment> getDoctorAppointments(long id);

    Appointment getAppointmentById(long id);

}
