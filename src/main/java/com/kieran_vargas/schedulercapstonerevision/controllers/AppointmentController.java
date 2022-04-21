package com.kieran_vargas.schedulercapstonerevision.controllers;

import java.security.Principal;
import java.util.List;

import com.kieran_vargas.schedulercapstonerevision.models.Appointment;
import com.kieran_vargas.schedulercapstonerevision.models.Doctor;
import com.kieran_vargas.schedulercapstonerevision.models.Patient;
import com.kieran_vargas.schedulercapstonerevision.services.AppointmentService;
import com.kieran_vargas.schedulercapstonerevision.services.DoctorService;
import com.kieran_vargas.schedulercapstonerevision.services.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppointmentController {

    private DoctorService doctorService;

    private PatientService patientService;

    private AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService, DoctorService doctorService,
            PatientService patientService) {
        this.appointmentService = appointmentService;
        this.doctorService = doctorService;
        this.patientService = patientService;
    }

    @GetMapping("/patient-appointments")
    public String viewPatientAppointments(Principal principal, Model model) {
        String email = principal.getName();
        Patient patient = patientService.findByEmail(email);
        List<Appointment> appointments = patient.getAppointments();
        model.addAttribute("listAppointments", appointments);
        return "patient-appointment-view";
    }

    @GetMapping("/doctor-appointments")
    public String viewDoctorAppointments(Principal principal, Model model) {
        String email = principal.getName();
        Doctor doctor = doctorService.findByEmail(email);
        List<Appointment> appointments = doctor.getAppointments();
        model.addAttribute("listAppointments", appointments);
        return "doctor-appointment-view";
    }

    @GetMapping("/addAppointmentForm")
    public String newAppointmentForm(Model model) {
        Appointment appointment = new Appointment();
        model.addAttribute("appointment", appointment);
        return "doctor-new-appointment";
    }

    @PostMapping("/saveAppointment")
    public String saveAppointment(@ModelAttribute("appointment") Appointment appointment, Principal principal) {
        String doctorEmail = principal.getName();
        Doctor doctor = doctorService.findByEmail(doctorEmail);
        String patientEmail = appointment.getPatientEmail();
        Patient patient = patientService.findByEmail(patientEmail);
        List<Appointment> doctorAppointments = doctor.getAppointments();
        List<Appointment> patientAppointments = patient.getAppointments();
        appointment.setPatient(patient);
        appointment.setPatientId(patient.getId());
        appointment.setPatientFirstName(patient.getFirstName());
        appointment.setPatientLastName(patient.getLastName());
        appointment.setPatientPhone(patient.getPhoneNumber());
        appointment.setPatientAddress(patient.getAddress());
        appointment.setDoctor(doctor);
        appointment.setDoctorId(doctor.getId());
        appointment.setDoctorFirstName(doctor.getFirstName());
        appointment.setDoctorLastName(doctor.getLastName());
        appointment.setDoctorEmail(doctor.getEmail());
        appointment.setDoctorPhone(doctor.getPhoneNumber());
        appointment.setDoctorAddress(doctor.getAddress());
        appointmentService.saveAppointment(appointment);
        patientAppointments.add(appointment);
        doctorAppointments.add(appointment);
        patientService.save(patient);
        doctorService.save(doctor);
        return "redirect:/doctor-appointments";
    }

    @GetMapping("/updateAppointmentForm/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model, Principal principal) {
        Appointment appointment = appointmentService.getAppointmentById(id);
        model.addAttribute("appointment", appointment);
        return "doctor-update-appointment";
    }

    @PostMapping("/updateAppointment")
    public String saveAppointment(@ModelAttribute("appointment") Appointment appointment, Principal principal,
            Model model) {
        appointmentService.saveAppointment(appointment);
        String email = principal.getName();
        Doctor doctor = doctorService.findByEmail(email);
        List<Appointment> appointments = doctor.getAppointments();
        model.addAttribute("listAppointments", appointments);
        return "redirect:/doctor-appointments";
    }

    @GetMapping("/deleteAppointment/{id}")
    public String deleteAppointment(@PathVariable(value = "id") long id, Principal principal) {

        Appointment appointment = appointmentService.getAppointmentById(id);
        String doctorEmail = principal.getName();
        Doctor doctor = doctorService.findByEmail(doctorEmail);
        String patientEmail = appointment.getPatientEmail();
        Patient patient = patientService.findByEmail(patientEmail);
        List<Appointment> doctorAppointments = doctor.getAppointments();
        List<Appointment> patientAppointments = patient.getAppointments();
        patientAppointments.remove(appointment);
        doctorAppointments.remove(appointment);
        patientService.save(patient);
        doctorService.save(doctor);
        this.appointmentService.deleteAppointmentById(id);
        return "redirect:/doctor-appointments";

    }

    @GetMapping("/viewAppointment/{id}")
    public String showAppointmentForViewing(@PathVariable(value = "id") long id, Model model) {
        Appointment appointment = appointmentService.getAppointmentById(id);
        model.addAttribute("appointment", appointment);
        return "patient-view-appointment";
    }

}