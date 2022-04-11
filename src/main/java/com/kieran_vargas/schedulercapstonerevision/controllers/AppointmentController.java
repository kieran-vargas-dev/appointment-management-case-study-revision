package com.kieran_vargas.schedulercapstonerevision.controllers;

import java.security.Principal;

import com.kieran_vargas.schedulercapstonerevision.models.Appointment;
import com.kieran_vargas.schedulercapstonerevision.services.AppointmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppointmentController {

    private AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listAppointments", appointmentService.getAllAppointments());
        return "index";
    }

    @GetMapping("/doctor-new-appointment")
    public String newAppointmentForm(Model model) {
        Appointment appointment = new Appointment();
        model.addAttribute("appointment", appointment);
        return "doctor-new-appointment";
    }

    @PostMapping("/saveAppointment")
    public String saveAppointment(@ModelAttribute("appointment") Appointment appointment, Principal principal) {
        appointmentService.saveAppointment(appointment);
        String appointmentDoctor = principal.getName();
        return "redirect:/";
    }

    @GetMapping("/updateAppointmentForm/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        Appointment appointment = appointmentService.getAppointmentById(id);

        model.addAttribute("appointment", appointment);
        return "doctor-update-appointment";
    }

    @GetMapping("/deleteAppointment/{id}")
    public String deleteAppointment(@PathVariable(value = "id") long id) {
        this.appointmentService.deleteAppointmentById(id);
        return "redirect:/";
    }

}