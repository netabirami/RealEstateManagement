package com.example.RealEstateManagement.service;

import com.example.RealEstateManagement.model.Property;
import com.example.RealEstateManagement.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    public List<Property> getAllProperty() {
        return propertyRepository.findAll();
    }

    public Property createProperty(Property property) {
        return propertyRepository.save(property);
    }

    public void deleteProperty(Long id) {
        propertyRepository.deleteById(id);
    }

    public Property getPropertyById(Long id) {
        return propertyRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Property not found with ID: " + id)
        );
    }

    public void updateProperty(Property existingProperty) {
        propertyRepository.save(existingProperty);
    }
}
