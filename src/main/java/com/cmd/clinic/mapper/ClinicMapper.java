package com.cmd.clinic.mapper;
import com.cmd.clinic.dto.ClinicDTO;
import com.cmd.clinic.entity.Clinic;
import org.springframework.stereotype.Component;

@Component
public class ClinicMapper {

    //DTo -> Entity
    public Clinic toEntity(ClinicDTO dto){
        if (dto==null) return null;

        Clinic clinic=new Clinic();
        clinic.setName(dto.getName());
        clinic.setAddress(dto.getAddress());
        clinic.setPhoneNumber(dto.getPhoneNumber());
        clinic.setType(dto.getType());

        return clinic;

    }

    //Entity-> DTO
    public ClinicDTO toDto(Clinic clinic){
        if(clinic==null) return null;

        return ClinicDTO.builder()
                .name(clinic.getName())
                .address(clinic.getAddress())
                .phoneNumber(clinic.getPhoneNumber())
                .type(clinic.getType())
                .build();
    }
}
