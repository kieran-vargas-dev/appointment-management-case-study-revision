package com.kieran_vargas.schedulercapstonerevision.services;

import java.util.List;

import com.kieran_vargas.schedulercapstonerevision.dtos.UserRegistrationDto;
import com.kieran_vargas.schedulercapstonerevision.models.Appointment;
import com.kieran_vargas.schedulercapstonerevision.models.Patient;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class PatientServiceImplementation implements PatientService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Appointment> getPatientAppointments(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Appointment getAppointmentById(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Patient findByEmail(String email) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Patient save(UserRegistrationDto registration) {
        // TODO Auto-generated method stub
        return null;
    }

}
