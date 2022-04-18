package com.kieran_vargas.schedulercapstonerevision.services;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.kieran_vargas.schedulercapstonerevision.dtos.UserRegistrationDto;
import com.kieran_vargas.schedulercapstonerevision.models.Appointment;
import com.kieran_vargas.schedulercapstonerevision.models.Patient;
import com.kieran_vargas.schedulercapstonerevision.repository.PatientRepository;
import com.kieran_vargas.schedulercapstonerevision.security.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImplementation implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    private PasswordEncoder passwordEncoder;

    public PatientServiceImplementation(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
        this.passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    public Patient findByEmail(String email) {
        return patientRepository.findByEmail(email);
    }

    public Patient save(UserRegistrationDto registration) {
        Patient patient = new Patient();
        patient.setFirstName(registration.getFirstName());
        patient.setLastName(registration.getLastName());
        patient.setEmail(registration.getEmail());
        patient.setPhoneNumber(registration.getPhone());
        patient.setAddress(registration.getAddress());
        patient.setPassword(passwordEncoder.encode(registration.getPassword()));
        return patientRepository.save(patient);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Patient patient = patientRepository.findByEmail(email);
        if (patient == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(patient.getEmail(),
                patient.getPassword(),
                mapRolesToAuthorities(patient.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
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
}