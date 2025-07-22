package com.cmd.clinic.controller;

import com.cmd.clinic.dto.DoctorDTO;
import com.cmd.clinic.entity.Doctor;
import com.cmd.clinic.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public ResponseEntity<DoctorDTO> addDoctor(@RequestBody @Valid DoctorDTO doctorDTO){
        DoctorDTO savedDoctor= doctorService.addDoctor(doctorDTO);
        return ResponseEntity.ok(savedDoctor);

    }


    @GetMapping
    public ResponseEntity<List<DoctorDTO>> getAllDoctors(){
        List<DoctorDTO> doctors=doctorService.getAllDoctors();
        return  ResponseEntity.ok(doctors);

    }



}
