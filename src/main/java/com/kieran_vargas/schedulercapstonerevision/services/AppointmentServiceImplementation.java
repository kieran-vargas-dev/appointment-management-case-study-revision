package com.kieran_vargas.schedulercapstonerevision.services;

import java.util.List;
import java.util.Optional;

import com.kieran_vargas.schedulercapstonerevision.models.Appointment;
import com.kieran_vargas.schedulercapstonerevision.repository.AppointmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImplementation implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment getAppointmentById(long id) {
        Optional<Appointment> optional = appointmentRepository.findById(id);
        Appointment appointment = null;
        if (optional.isPresent()) {
            appointment = optional.get();
        } else {
            throw new RuntimeException("Appointment not found for ID :: " + id);
        }
        return appointment;
    }

    @Override
    public void saveAppointment(Appointment appointment) {
        this.appointmentRepository.save(appointment);
    }

    @Override
    public void deleteAppointmentById(long id) {
        this.appointmentRepository.deleteById(id);
        ;
    }

}
