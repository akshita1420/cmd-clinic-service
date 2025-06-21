package com.cmd.clinic.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClinicDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "address is required")
    private String address;

    @NotBlank(message = "phoneNumber is required")
    private String phoneNumber;

    @NotNull(message = "Clinic is required")
    private String type;

}
