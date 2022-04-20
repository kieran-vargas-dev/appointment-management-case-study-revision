package com.kieran_vargas.schedulercapstonerevision.repository;

import java.util.List;

import com.kieran_vargas.schedulercapstonerevision.models.Appointment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    Appointment findAppointmentById(long id);

    List<Appointment> findByDoctorId(long doctorId);

    List<Appointment> findByPatientId(long patientId);

}
