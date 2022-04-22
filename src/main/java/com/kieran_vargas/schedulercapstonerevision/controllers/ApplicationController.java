package com.kieran_vargas.schedulercapstonerevision.controllers;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

import com.kieran_vargas.schedulercapstonerevision.models.Doctor;
import com.kieran_vargas.schedulercapstonerevision.security.Role;
import com.kieran_vargas.schedulercapstonerevision.security.User;
import com.kieran_vargas.schedulercapstonerevision.security.UserService;
import com.kieran_vargas.schedulercapstonerevision.services.DoctorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String root(Principal principal) {
        String currentUserEmail = principal.getName();
        User currentUser = userService.findByEmail(currentUserEmail);
        Collection<Role> currentUserRoles = currentUser.getRoles();
        for (Role currentUserRole : currentUserRoles) {
            String roleName = currentUserRole.getName();
            if (roleName.equals("ROLE_DOCTOR")) {
                return "doctor-homepage";
            }
        }
        return "patient-homepage";
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
