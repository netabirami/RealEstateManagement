package com.example.RealEstateManagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @NotNull(message = "The Address should not be Null.")
    private String address;
    @NotNull(message = "The Building Type should not be Null.")
    private String buildingType;
    @NotNull(message = "The Price should not be Null.")
    @Min(2_00_000) @Max(10_00_000)
    private Double price;
    @NotNull(message = "The Area should not be Null.")
    @Min(40)  @Max(600)
    private Double area;
    @NotNull(message = "The number of bedrooms should not be Null.")
    @Min(2) @Max(5)
    private Integer bedrooms;
    @NotNull(message = "The number of Bathroom should not be Null.")
    @Min(1) @Max(3)
    private Integer bathrooms;
    @NotNull(message = "The date cannot be Null.")
    @Future(message = "The date should be in Future." )
    private Date listingDate;

    @ManyToOne
    @JoinColumn(name = "realestate_agent_id")
    private RealEstateAgent realEstateAgent;

}
