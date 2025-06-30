package com.cmd.clinic.dto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClinicDTO {

    private String clinicId;

    @NotBlank(message = "Name is required")
    private String name;

    private String businessName;

    @NotBlank(message = "address is required")
    private String address;

    private String streetAddress;
    private String city;
    private String state;
    private String country;
    private String zipCode;

    @NotBlank(message = "phoneNumber is required")
    private String phoneNumber;
    private String latitude;
    private String longitude;


    @NotNull(message = "Clinic is required")
    private String type;

    private List<ServiceDTO> services;
}