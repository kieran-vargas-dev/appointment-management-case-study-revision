package com.kieran_vargas.schedulercapstonerevision.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import com.kieran_vargas.schedulercapstonerevision.dtos.UserRegistrationDto;
import com.kieran_vargas.schedulercapstonerevision.models.Doctor;
import com.kieran_vargas.schedulercapstonerevision.models.Patient;
import com.kieran_vargas.schedulercapstonerevision.repository.DoctorRepository;
import com.kieran_vargas.schedulercapstonerevision.repository.PatientRepository;
import com.kieran_vargas.schedulercapstonerevision.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired

    private UserRepository userRepository;

    private DoctorRepository doctorRepository;

    private PatientRepository patientRepository;

    private PasswordEncoder passwordEncoder;

    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User saveUser(UserRegistrationDto registration) {
        User user = new User();
        user.setFirstName(registration.getFirstName());
        user.setLastName(registration.getLastName());
        user.setEmail(registration.getEmail());
        user.setPassword(passwordEncoder.encode(registration.getPassword()));
        user.setRoles(Arrays.asList(new Role("ROLE_USER")));
        return userRepository.save(user);
    }

    public Doctor saveDoctor(UserRegistrationDto registration) {
        Doctor doctor = new Doctor();
        doctor.setFirstName(registration.getFirstName());
        doctor.setLastName(registration.getLastName());
        doctor.setEmail(registration.getEmail());
        doctor.setPassword(passwordEncoder.encode(registration.getPassword()));
        doctor.setAddress(registration.getAddress());
        doctor.setPhoneNumber(registration.getPhone());
        doctor.setRoles(Arrays.asList(new Role("ROLE_DOCTOR")));
        return doctorRepository.save(doctor);
    }

    public Patient savePatientr(UserRegistrationDto registration) {
        Patient patient = new Patient();
        patient.setFirstName(registration.getFirstName());
        patient.setLastName(registration.getLastName());
        patient.setEmail(registration.getEmail());
        patient.setPassword(passwordEncoder.encode(registration.getPassword()));
        patient.setAddress(registration.getAddress());
        patient.setPhoneNumber(registration.getPhone());
        patient.setRoles(Arrays.asList(new Role("ROLE_PATIENT")));
        return patientRepository.save(patient);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
