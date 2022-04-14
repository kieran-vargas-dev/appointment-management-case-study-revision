package com.kieran_vargas.schedulercapstonerevision.services;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.kieran_vargas.schedulercapstonerevision.dtos.UserRegistrationDto;
import com.kieran_vargas.schedulercapstonerevision.models.Appointment;
import com.kieran_vargas.schedulercapstonerevision.models.Doctor;
import com.kieran_vargas.schedulercapstonerevision.repository.DoctorRepository;
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
public class DoctorServiceImplementation implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    private PasswordEncoder passwordEncoder;

    public DoctorServiceImplementation(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
        this.passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    public Doctor findByEmail(String email) {
        return doctorRepository.findByEmail(email);
    }

    public Doctor save(UserRegistrationDto registration) {
        Doctor doctor = new Doctor();
        doctor.setFirstName(registration.getFirstName());
        doctor.setLastName(registration.getLastName());
        doctor.setEmail(registration.getEmail());
        doctor.setPassword(passwordEncoder.encode(registration.getPassword()));
        doctor.setRoles(Arrays.asList(new Role("ROLE_DOCTOR")));
        return doctorRepository.save(doctor);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Doctor doctor = doctorRepository.findByEmail(email);
        if (doctor == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(doctor.getEmail(),
                doctor.getPassword(),
                mapRolesToAuthorities(doctor.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

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
}
