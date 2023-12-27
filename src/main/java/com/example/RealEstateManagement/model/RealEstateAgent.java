package com.example.RealEstateManagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RealEstateAgent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @NotNull(message = "The Name should not be Null.")
    private String name;
    @NotNull(message = "The Email should not be Null.")
    private String email;
    @NotNull(message = "The Phone should not be Null.")
    private String phone;

    @OneToMany(mappedBy = "realEstateAgent", cascade = CascadeType.ALL)
    private List<Property> properties;
}
