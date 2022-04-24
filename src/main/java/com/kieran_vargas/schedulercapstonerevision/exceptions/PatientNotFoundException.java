package com.kieran_vargas.schedulercapstonerevision.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "No patient has registered for the app with that email.")
public class PatientNotFoundException extends RuntimeException {

}