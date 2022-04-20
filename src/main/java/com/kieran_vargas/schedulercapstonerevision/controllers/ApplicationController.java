package com.kieran_vargas.schedulercapstonerevision.controllers;

import java.util.List;

import com.kieran_vargas.schedulercapstonerevision.models.Doctor;
import com.kieran_vargas.schedulercapstonerevision.services.DoctorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    private DoctorService doctorService;

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @Autowired
    public ApplicationController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/care-providers")
    public String viewCareProviders(Model model) {
        List<Doctor> doctors = doctorService.getAllDoctors();
        model.addAttribute("listDoctors", doctors);
        return "care-provider-browser";
    }

}
