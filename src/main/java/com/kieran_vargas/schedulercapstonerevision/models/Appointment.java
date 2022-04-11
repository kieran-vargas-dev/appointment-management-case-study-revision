package com.kieran_vargas.schedulercapstonerevision.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "APPOINTMENTS")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "APPOINTMENT_PATIENT")
    private Patient patient;

    @Column(name = "PATIENT_ID")
    private long patientId;

    @Column(name = "PATIENT_FIRST_NAME")
    private String patientFirstName;

    @Column(name = "PATIENT_LAST_NAME")
    private String patientLastName;

    @Column(name = "PATIENT_EMAIL")
    private String patientEmail;

    @Column(name = "APPOINTMENT_DATE")
    private Date appointmentDate;

    @ManyToOne
    @JoinColumn(name = "APPOINTMENT_DOCTOR")
    private Doctor doctor;

    @Column(name = "DOCTOR_ID")
    private long doctorId;

    @Column(name = "DOCTOR_FIRST_NAME")
    private String doctorFirstName;

    @Column(name = "DOCTOR_LAST_NAME")
    private String doctorLastName;

    @Column(name = "DOCTOR_EMAIL")
    private String doctorEmail;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorFirstName() {
        return doctorFirstName;
    }

    public void setDoctorFirstName(String doctorFirstName) {
        this.doctorFirstName = doctorFirstName;
    }

    public String getDoctorLastName() {
        return doctorLastName;
    }

    public void setDoctorLastName(String doctorLastName) {
        this.doctorLastName = doctorLastName;
    }

    public String getDoctorEmail() {
        return doctorEmail;
    }

    public void setDoctorEmail(String doctorEmail) {
        this.doctorEmail = doctorEmail;
    }

    public Appointment() {
    }

    public Appointment(long id, Patient patient, long patientId, String patientFirstName, String patientLastName,
            String patientEmail, Date appointmentDate, Doctor doctor, long doctorId, String doctorFirstName,
            String doctorLastName, String doctorEmail) {
        this.id = id;
        this.patient = patient;
        this.patientId = patientId;
        this.patientFirstName = patientFirstName;
        this.patientLastName = patientLastName;
        this.patientEmail = patientEmail;
        this.appointmentDate = appointmentDate;
        this.doctor = doctor;
        this.doctorId = doctorId;
        this.doctorFirstName = doctorFirstName;
        this.doctorLastName = doctorLastName;
        this.doctorEmail = doctorEmail;
    }

}
