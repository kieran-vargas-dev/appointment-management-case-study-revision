package com.kieran_vargas.schedulercapstonerevision.controllers;

import javax.validation.Valid;

import com.kieran_vargas.schedulercapstonerevision.dtos.UserRegistrationDto;
import com.kieran_vargas.schedulercapstonerevision.models.Doctor;
import com.kieran_vargas.schedulercapstonerevision.models.Patient;
import com.kieran_vargas.schedulercapstonerevision.security.User;
import com.kieran_vargas.schedulercapstonerevision.security.UserService;
import com.kieran_vargas.schedulercapstonerevision.services.DoctorService;
import com.kieran_vargas.schedulercapstonerevision.services.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto,
            BindingResult result) {

        User existing = userService.findByEmail(userDto.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()) {
            return "registration";
        }

        userService.saveUser(userDto);

        if (userDto.getUserType().equals("doctor")) {
            Doctor doctor = createDoctorFromUserDto(userDto);
            doctorService.save(doctor);
        }

        if (userDto.getUserType().equals("patient")) {
            Patient patient = createPatientFromUserDto(userDto);
            patientService.save(patient);
        }

        return "redirect:/registration?success";

    }

    public Doctor createDoctorFromUserDto(UserRegistrationDto userDto) {
        Doctor doctor = new Doctor();
        doctor.setEmail(userDto.getEmail());
        doctor.setFirstName(userDto.getFirstName());
        doctor.setLastName(userDto.getLastName());
        doctor.setPhoneNumber(userDto.getPhone());
        doctor.setAddress(userDto.getAddress());
        doctor.setPassword(userDto.getPassword());
        return doctor;
    }

    public Patient createPatientFromUserDto(UserRegistrationDto userDto) {
        Patient patient = new Patient();
        patient.setEmail(userDto.getEmail());
        patient.setFirstName(userDto.getFirstName());
        patient.setLastName(userDto.getLastName());
        patient.setPhoneNumber(userDto.getPhone());
        patient.setAddress(userDto.getAddress());
        patient.setPassword(userDto.getPassword());
        return patient;
    }

}
