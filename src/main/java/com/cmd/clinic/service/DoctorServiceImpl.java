package com.cmd.clinic.service;

import com.cmd.clinic.dto.DoctorDTO;
import com.cmd.clinic.entity.Doctor;
import com.cmd.clinic.mapper.DoctorMapper;
import com.cmd.clinic.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService{

    @Autowired
    public DoctorRepository doctorRepository             ;

    @Autowired
    public DoctorMapper doctorMapper;

    @Override
    public DoctorDTO addDoctor(DoctorDTO doctorDTO) {

        //dto->doctor
        Doctor doctor=doctorMapper.toEntity(doctorDTO);

        //save to db
        Doctor savedDoctor=doctorRepository.save(doctor);


        //doctor-> dto
        return doctorMapper.toDTO(savedDoctor);

    }

    @Override
    public List<DoctorDTO> getAllDoctors() {
        return doctorRepository.findAll()
                .stream()
                .map(doctorMapper::toDTO)
                .collect(Collectors.toList());
    }
}
