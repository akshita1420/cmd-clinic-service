package com.cmd.clinic.controller;

import com.cmd.clinic.dto.ClinicDTO;
import com.cmd.clinic.service.ClinicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clinics")
public class
ClinicController {

    @Autowired
    private ClinicService clinicService;


    @PostMapping
    public ResponseEntity<ClinicDTO> addClinic(@RequestBody @Valid ClinicDTO clinicDTO) {
        ClinicDTO savedClinic = clinicService.addClinic(clinicDTO);
        return ResponseEntity.ok(savedClinic);
    }
    @GetMapping
    public ResponseEntity<List<ClinicDTO>> getAllClinics(){
        List<ClinicDTO> clinics =clinicService.getAllClinics();
        return ResponseEntity.ok(clinics);
    }
}
