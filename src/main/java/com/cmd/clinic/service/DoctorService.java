package com.cmd.clinic.service;

import com.cmd.clinic.dto.DoctorDTO;

import java.util.List;

public interface DoctorService {
    DoctorDTO addDoctor(DoctorDTO doctorDTO);
    List<DoctorDTO> getAllDoctors();

}
