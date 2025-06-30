package com.cmd.clinic.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="services")
public class Service {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String serviceId;

    private String serviceName;

    private String serviceCode;

    private String serviceDescription;

    private Double averagePrice;

    private Boolean isActive;
}
