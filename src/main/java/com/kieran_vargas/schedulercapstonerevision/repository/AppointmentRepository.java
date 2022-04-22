package com.kieran_vargas.schedulercapstonerevision.repository;

import java.util.List;

import com.kieran_vargas.schedulercapstonerevision.models.Appointment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    Appointment findAppointmentById(long id);

    // The findByDoctorId and findByPatientId functions exist for use by an
    // administrative role that will be implemented in the future.

    List<Appointment> findByDoctorId(long doctorId);

    List<Appointment> findByPatientId(long patientId);

}
