package com.cmd.clinic.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentDTO {

    private Long appointmentId;

    @NotNull(message = "Clinic ID is required")
    private Long clinicId;

    @NotNull(message = "Doctor ID is required")
    private Long doctorId;

    @FutureOrPresent(message = "Appointment date must be today or in the future")
    @NotNull(message = "Appointment date is required")
    private LocalDate appointmentDate;

    @NotNull(message = "Appointment time is required")
    private LocalTime appointmentTime;

    @NotBlank(message = "Patient name is required")
    private String patientName;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String patientEmail;

    @NotBlank(message = "Phone number is required")
    private String patientPhone;

    private String reason;


    private String status = "Scheduled";
}
