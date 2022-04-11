package com.kieran_vargas.schedulercapstonerevision.services;

import java.util.List;

import com.kieran_vargas.schedulercapstonerevision.models.Appointment;

public interface AppointmentService {

    List<Appointment> getAllAppointments();

    Appointment getAppointmentById(long id);

    void saveAppointment(Appointment appointment);

    void deleteAppointmentById(long id);

}
