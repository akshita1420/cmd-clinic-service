package com.cmd.clinic.mapper;

import com.cmd.clinic.dto.DoctorDTO;
import com.cmd.clinic.entity.Doctor;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

import javax.print.Doc;

@Component
public class DoctorMapper {

    public Doctor toEntity(DoctorDTO dto){
        if(dto==null){
            return null;
        }

        return Doctor.builder()
                .doctorId(dto.getDoctorId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .phoneNumber(dto.getPhoneNumber())
                .specialization(dto.getSpecialization())
                .availableDays(dto.getAvailableDays())
                .isActive(dto.isActive())
                .build();
    }

    public DoctorDTO toDTO(@NotNull Doctor doctor){
        return DoctorDTO.builder()
                .doctorId(doctor.getDoctorId())
                .firstName(doctor.getFirstName())
                .lastName(doctor.getLastName())
                .email(doctor.getEmail())
                .phoneNumber(doctor.getPhoneNumber())
                .specialization(doctor.getSpecialization())
                .availableDays(doctor.getAvailableDays())
                .isActive(doctor.isActive())
                .build();

    }

}
