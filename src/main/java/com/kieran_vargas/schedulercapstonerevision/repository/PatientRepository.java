package com.kieran_vargas.schedulercapstonerevision.repository;

import com.kieran_vargas.schedulercapstonerevision.models.Patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findPatientById(long id);
}
