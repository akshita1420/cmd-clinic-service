package com.cmd.clinic.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "clinics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Clinic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //primary key
    private Long id;


    private String clinicId;

    private String name;

    private String businessName;

    private String streetAddress;
    private String city;
    private String state;
    private String country;
    private String zipCode;

    private String phoneNumber;
    private String latitude;
    private String longitude;

    private String type;

    @CreationTimestamp
    private Date dateCreated;


    @OneToMany(cascade=CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="clinic_id")
    private List<Service> services;
}
