package com.example.RealEstateManagement.controller;

import com.example.RealEstateManagement.exception.InvalidMethodArgumentException;
import com.example.RealEstateManagement.model.Property;
import com.example.RealEstateManagement.service.PropertyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@Validated
@RequestMapping("/properties")
public class PropertyController {
    @Autowired
    private PropertyService propertyService;

    @GetMapping
    public List<Property> getAllProperty() {
        return propertyService.getAllProperty();
    }

    @GetMapping("/{id}")
    public Property getPropertyById(@PathVariable Long id) {
        return propertyService.getPropertyById(id);
    }


    @PostMapping
    public Property addProperty(@Valid @RequestBody Property property) {
        if (property.getBuildingType().equalsIgnoreCase("House") ||
                property.getBuildingType().equalsIgnoreCase("Apartment")){
            return propertyService.createProperty(property);
        }
        else {
            throw new InvalidMethodArgumentException("buildingType",
                    "Invalid building type. It should be either 'House' or 'Apartment'.");
        }
    }

    @PutMapping("/{id}")
    public Property updateProperty(@PathVariable Long id, @Valid @RequestBody Property updatedProperty) {
        Property existingProperty = propertyService.getPropertyById(id);
        if (existingProperty == null) {
            throw new NoSuchElementException("property with Id not found " + id);
        }
        existingProperty.setPrice(updatedProperty.getPrice());
        propertyService.updateProperty(existingProperty);
        return existingProperty;
    }
    @DeleteMapping("/{id}")
    public void deleteProperty(@PathVariable Long id) {
        propertyService.deleteProperty(id);
    }
}