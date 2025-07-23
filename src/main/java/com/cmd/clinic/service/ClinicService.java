package com.cmd.clinic.service;

import com.cmd.clinic.dto.ClinicDTO;

import java.util.List;

public interface ClinicService {
    ClinicDTO addClinic(ClinicDTO clinicDTO);

    List<ClinicDTO> getAllClinics();

}
