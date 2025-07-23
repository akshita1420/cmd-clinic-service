package com.cmd.clinic.service;

import com.cmd.clinic.dto.AppointmentDTO;

import java.util.List;

public interface AppointmentService {
    AppointmentDTO addAppointment(AppointmentDTO appointmentDTO);

    List<AppointmentDTO> getAllAppointments();


}
