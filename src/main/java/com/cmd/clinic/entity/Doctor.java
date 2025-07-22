package com.cmd.clinic.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name="doctors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId;

    @NotBlank(message = "First name is required")
    private String firstName;
    @NotBlank(message = "First name is required")

    private String lastName;
    private String email;
    @NotBlank(message = "Phone number is required")
    private String phoneNumber;
    private String specialization;
    private String availableDays;
    private boolean isActive;
}