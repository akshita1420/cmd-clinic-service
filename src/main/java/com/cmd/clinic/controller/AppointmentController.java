package com.cmd.clinic.controller;


import com.cmd.clinic.dto.AppointmentDTO;
import com.cmd.clinic.entity.Appointment;
import com.cmd.clinic.service.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<AppointmentDTO> addAppointment(@RequestBody @Valid AppointmentDTO appointmentDTO){
        AppointmentDTO savedAppointment=appointmentService.addAppointment(appointmentDTO);
        return ResponseEntity.ok(savedAppointment);
    }
    @GetMapping
    public ResponseEntity<List<AppointmentDTO>> getAllAppointments(){
        List<AppointmentDTO> appointments= appointmentService.getAllAppointments();
        return ResponseEntity.ok(appointments);
    }
}
