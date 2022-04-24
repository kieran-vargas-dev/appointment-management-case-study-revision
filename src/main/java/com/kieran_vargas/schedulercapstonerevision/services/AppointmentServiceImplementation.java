package com.kieran_vargas.schedulercapstonerevision.services;

import java.util.List;
import java.util.Optional;

import com.kieran_vargas.schedulercapstonerevision.exceptions.PatientNotFoundException;
import com.kieran_vargas.schedulercapstonerevision.models.Appointment;
import com.kieran_vargas.schedulercapstonerevision.models.Patient;
import com.kieran_vargas.schedulercapstonerevision.repository.AppointmentRepository;
import com.kieran_vargas.schedulercapstonerevision.repository.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImplementation implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

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
            throw new RuntimeException("Appointment not found for ID : " + id);
        }
        return appointment;
    }

    @Override
    public void saveAppointment(Appointment appointment) {
        Optional<Patient> optionalPatient = patientRepository.findById(appointment.getPatientId());
        if (optionalPatient.isPresent()) {
            this.appointmentRepository.save(appointment);
        } else {
            throw new PatientNotFoundException();
        }
    }

    @Override
    public void deleteAppointmentById(long id) {
        this.appointmentRepository.deleteById(id);
    }

    @Override
    public List<Appointment> getDoctorAppointments(long doctorId) {
        return appointmentRepository.findByDoctorId(doctorId);
    }

    @Override
    public List<Appointment> getPatientAppointments(long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }

}
