// package com.kieran_vargas.schedulercapstonerevision.controllers;

// import javax.validation.Valid;

// import com.kieran_vargas.schedulercapstonerevision.dtos.UserRegistrationDto;
// import com.kieran_vargas.schedulercapstonerevision.models.Doctor;
// import com.kieran_vargas.schedulercapstonerevision.services.DoctorService;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.validation.BindingResult;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;

// @Controller
// @RequestMapping("/doctor-registration")
// public class DoctorRegistrationController {

// @Autowired
// private DoctorService doctorService;

// @ModelAttribute("doctor")
// public UserRegistrationDto doctorRegistrationDto() {
// return new UserRegistrationDto();
// }

// @GetMapping
// public String showRegistrationForm(Model model) {
// return "doctor-registration";
// }

// @PostMapping
// public String registerDoctorAccount(@ModelAttribute("doctor") @Valid
// UserRegistrationDto doctorDto,
// BindingResult result) {

// Doctor existing = doctorService.findByEmail(doctorDto.getEmail());
// if (existing != null) {
// result.rejectValue("email", null, "There is already an account registered
// with that email");
// }

// if (result.hasErrors()) {
// return "doctor-registration";
// }

// doctorService.save(doctorDto);
// return "redirect:/doctor-registration?success";
// }
// }