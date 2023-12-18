package com.example.RealEstateManagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String buildingType;
    private double price;
    private double area;
    private int bedrooms;
    private int bathrooms;
    private Date listingDate;

    @ManyToOne
    @JoinColumn(name = "realestate_agent_id")
    private RealEstateAgent realEstateAgent;

}
