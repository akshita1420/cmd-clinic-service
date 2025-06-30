package com.cmd.clinic.mapper;

import com.cmd.clinic.dto.ServiceDTO;
import com.cmd.clinic.entity.Service;
import org.springframework.stereotype.Component;

@Component
public class ServiceMapper {

    public Service toEntity(ServiceDTO dto){
        if(dto==null) return null;

        Service service =new Service();
        service.setServiceName(dto.getServiceName());
        service.setServiceCode(dto.getServiceCode());
        service.setServiceDescription(dto.getServiceDescription());
        service.setAveragePrice(dto.getAveragePrice());
        service.setIsActive(dto.getIsActive());

        return service;

    }

    public ServiceDTO toDTO(Service service){
        if(service==null) return null;


        return ServiceDTO.builder()
                .serviceName(service.getServiceName())
                .serviceCode(service.getServiceCode())
                .serviceId(service.getServiceId())
                .serviceDescription(service.getServiceDescription())
                .averagePrice(service.getAveragePrice())
                .isActive((service.getIsActive()))
                .build();




    }
}
