package com.cmd.clinic.service;

import com.cmd.clinic.entity.Clinic;
import com.cmd.clinic.dto.ClinicDTO;
import com.cmd.clinic.repository.ClinicRepository;
import com.cmd.clinic.mapper.ClinicMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClinicServiceImpl implements ClinicService {

    @Autowired
    private ClinicRepository clinicRepository;

    @Autowired
    private ClinicMapper clinicMapper;

    @Override
    public ClinicDTO addClinic(ClinicDTO clinicDTO){

        //convert dto -> entity
        Clinic clinic = clinicMapper.toEntity(clinicDTO);

        //save to db
        Clinic savedclinic =clinicRepository.save(clinic);

        //convert back to dto(with maybe id now)
        return clinicMapper.toDto((savedclinic));

    }
    @Override
    public List<ClinicDTO> getAllClinics(){
        return clinicRepository.findAll()
                .stream()
                .map(clinicMapper::toDto)
                .collect(Collectors.toList());
    }
}
