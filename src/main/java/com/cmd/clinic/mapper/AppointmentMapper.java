package com.cmd.clinic.mapper;

import com.cmd.clinic.dto.AppointmentDTO;
import com.cmd.clinic.entity.Appointment;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {

    public Appointment toEntity(AppointmentDTO dto){
        if(dto==null){
            return null;
        }

        return Appointment.builder()
                .appointmentId(dto.getAppointmentId())
                .clinicId(dto.getClinicId())
                .doctorId(dto.getDoctorId())
                .appointmentDate(dto.getAppointmentDate())
                .appointmentTime(dto.getAppointmentTime())
                .patientName(dto.getPatientName())
                .patientEmail(dto.getPatientEmail())
                .patientPhone(dto.getPatientPhone())
                .reason(dto.getReason())
                .status(dto.getStatus())
                .build();
    }
    public AppointmentDTO toDTO(Appointment appointment){

        return AppointmentDTO.builder()
                .appointmentId(appointment.getAppointmentId())
                .clinicId(appointment.getClinicId())
                .doctorId(appointment.getDoctorId())
                .appointmentDate(appointment.getAppointmentDate())
                .appointmentTime(appointment.getAppointmentTime())
                .patientName(appointment.getPatientName())
                .patientEmail(appointment.getPatientEmail())
                .patientPhone(appointment.getPatientPhone())
                .reason(appointment.getReason())
                .status(appointment.getStatus())
                .build();
    }





}
