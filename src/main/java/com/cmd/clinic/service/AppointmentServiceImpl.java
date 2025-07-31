package com.cmd.clinic.service;

import com.cmd.clinic.dto.AppointmentDTO;
import com.cmd.clinic.entity.Appointment;
import com.cmd.clinic.mapper.AppointmentMapper;
import com.cmd.clinic.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private static final Logger logger = LoggerFactory.getLogger(AppointmentServiceImpl.class);

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private AppointmentMapper appointmentMapper;

    @Override
    public AppointmentDTO addAppointment(AppointmentDTO appointmentDTO) {
        logger.info("[LOW][AppointmentServiceImpl][addAppointment] Request to add appointment for patient: {}", appointmentDTO.getPatientName());

        if (appointmentDTO == null) {
            logger.error("[CRITICAL][AppointmentServiceImpl][addAppointment] AppointmentDTO is null. Cannot proceed.");
            throw new IllegalArgumentException("AppointmentDTO cannot be null");
        }

        if (appointmentDTO.getAppointmentDate().isBefore(LocalDate.now())) {
            logger.warn("[MEDIUM][AppointmentServiceImpl][addAppointment] Appointment date is in the past: {}", appointmentDTO.getAppointmentDate());
            throw new IllegalArgumentException("Appointment date cannot be in the past");
        }

        Appointment appointment = appointmentMapper.toEntity(appointmentDTO);
        logger.debug("[LOW][AppointmentServiceImpl][addAppointment] Mapped DTO to entity: {}", appointment);

        Appointment savedAppointment = appointmentRepository.save(appointment);
        logger.info("[LOW][AppointmentServiceImpl][addAppointment] Appointment saved successfully with ID: {}", savedAppointment.getAppointmentId());

        return appointmentMapper.toDTO(savedAppointment);
    }

    @Override
    public List<AppointmentDTO> getAllAppointments() {
        logger.info("[LOW][AppointmentServiceImpl][getAllAppointments] Fetching all appointments.");
        return appointmentRepository.findAll()
                .stream()
                .map(appointmentMapper::toDTO)
                .toList();
    }
}
