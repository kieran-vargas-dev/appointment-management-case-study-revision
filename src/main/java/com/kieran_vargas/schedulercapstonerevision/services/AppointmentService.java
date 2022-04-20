package com.kieran_vargas.schedulercapstonerevision.services;

import java.util.List;

import com.kieran_vargas.schedulercapstonerevision.models.Appointment;

public interface AppointmentService {

    List<Appointment> getAllAppointments();

    List<Appointment> getDoctorAppointments(long doctorId);

    List<Appointment> getPatientAppointments(long patientId);

    Appointment getAppointmentById(long id);

    void saveAppointment(Appointment appointment);

    void deleteAppointmentById(long id);

}
