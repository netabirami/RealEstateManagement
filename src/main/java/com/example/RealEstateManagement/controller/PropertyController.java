package com.example.RealEstateManagement.controller;

import com.example.RealEstateManagement.exception.ResourceNotFoundException;
import com.example.RealEstateManagement.model.Property;
import com.example.RealEstateManagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
    public Property addProperty(@RequestBody Property property) {
        return propertyService.createProperty(property);
    }

    @PutMapping("/{id}")
    public Property updateProperty(@PathVariable Long id, @RequestBody Property updatedProperty) {
        Property existingProperty = propertyService.getPropertyById(id);
        if (existingProperty == null) {
            throw new ResourceNotFoundException("property with Id not found " + id);
        }
        existingProperty.setPrice(updatedProperty.getPrice());
        return existingProperty;
    }
    @DeleteMapping("/{id}")
    public void deleteProperty(@PathVariable Long id) {
        propertyService.deleteProperty(id);
    }
}