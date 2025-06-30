package com.cmd.clinic.mapper;
import com.cmd.clinic.dto.ClinicDTO;
import com.cmd.clinic.entity.Clinic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




@Component
public class ClinicMapper {

    //DTo -> Entity
    public Clinic toEntity(ClinicDTO dto){
        if (dto==null) return null;

        Clinic clinic=new Clinic();
        clinic.setName(dto.getName());
        clinic.setStreetAddress(dto.getStreetAddress());
        clinic.setCity(dto.getCity());
        clinic.setState(dto.getState());
        clinic.setCountry(dto.getCountry());
        clinic.setZipCode(dto.getZipCode());
        clinic.setPhoneNumber(dto.getPhoneNumber());
        clinic.setType(dto.getType());

        return clinic;

    }






    //Entity-> DTO
    public ClinicDTO toDto(Clinic clinic){
        if(clinic==null) return null;

        return ClinicDTO.builder()
                .name(clinic.getName())
                .streetAddress(clinic.getStreetAddress())
                .city(clinic.getCity())
                .state(clinic.getState())
                .country(clinic.getCountry())
                .zipCode(clinic.getZipCode())
                .phoneNumber(clinic.getPhoneNumber())
                .type(clinic.getType())
                .build();
    }


}
