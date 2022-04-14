// package com.kieran_vargas.schedulercapstonerevision.controllers;

// import javax.validation.Valid;

// import com.kieran_vargas.schedulercapstonerevision.dtos.UserRegistrationDto;
// import com.kieran_vargas.schedulercapstonerevision.models.Patient;
// import com.kieran_vargas.schedulercapstonerevision.services.PatientService;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.validation.BindingResult;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;

// @Controller
// @RequestMapping("/registration")
// public class PatientRegistrationController {

// @Autowired
// private PatientService patientService;

// @ModelAttribute("patient")
// public UserRegistrationDto patientRegistrationDto() {
// return new UserRegistrationDto();
// }

// @GetMapping
// public String showRegistrationForm(Model model) {
// return "registration";
// }

// @PostMapping
// public String registerPatientAccount(@ModelAttribute("patient") @Valid
// UserRegistrationDto patientDto,
// BindingResult result) {

// Patient existing = patientService.findByEmail(patientDto.getEmail());
// if (existing != null) {
// result.rejectValue("email", null, "There is already an account registered
// with that email");
// }

// if (result.hasErrors()) {
// return "registration";
// }

// patientService.save(patientDto);
// return "redirect:/registration?success";
// }
// }