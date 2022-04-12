package com.kieran_vargas.schedulercapstonerevision.services;

import java.util.List;

import com.kieran_vargas.schedulercapstonerevision.dtos.DoctorRegistrationDto;
import com.kieran_vargas.schedulercapstonerevision.models.Appointment;
import com.kieran_vargas.schedulercapstonerevision.models.Doctor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class DoctorServiceImplementation implements DoctorService {

    @Override
    public List<Appointment> getDoctorAppointments(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Appointment getAppointmentById(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Doctor findByEmail(String email) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Doctor save(DoctorRegistrationDto registration) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }

}
