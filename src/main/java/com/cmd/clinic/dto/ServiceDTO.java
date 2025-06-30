package com.cmd.clinic.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Setter;
import lombok.Getter;

import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ServiceDTO {
    private String serviceId;

    @NotBlank(message = "Service name is required")
    private String serviceName;

    @NotBlank(message = "Service code is required")
    private String serviceCode;

    private String serviceDescription;
    private Double averagePrice;

    private Boolean isActive;

}
