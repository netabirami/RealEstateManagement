package com.example.RealEstateManagement.controller;

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
    public List<Property> getAllProperty(){
        return  propertyService.getAllProperty();
    }

    @PostMapping
    public Property addProperty (@RequestBody Property property) {
        return propertyService.createProperty(property);
    }
    @DeleteMapping("/{id}")
    public void deleteProperty(@PathVariable Long id){
          propertyService.deleteProperty(id);
    }
}