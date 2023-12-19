package com.example.RealEstateManagement.controller;

import com.example.RealEstateManagement.exception.ResourceNotFoundException;
import com.example.RealEstateManagement.model.RealEstateAgent;
import com.example.RealEstateManagement.service.RealEstateAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/realestateagents")
public class RealEstateAgentController {
    @Autowired
    private RealEstateAgentService realEstateAgentService;

    @GetMapping
    public List<RealEstateAgent> getAllRealEstateAgent() {
        return realEstateAgentService.getAllRealEstateAgent();
    }

    @PostMapping
    public RealEstateAgent addRealEstateAgent(@RequestBody RealEstateAgent property) {
        return realEstateAgentService.createRealEstateAgent(property);
    }

    @DeleteMapping("/{id}")
    public void deleteRealEstateAgent(@PathVariable Long id) {
        realEstateAgentService.deleteRealEstateAgent(id);
    }

    @GetMapping("/{id}")
    public RealEstateAgent getRealEstateAgentById(@PathVariable Long id) {
        return realEstateAgentService.getRealEstateAgentById(id);
    }

    @PutMapping("/{id}")
    public RealEstateAgent updateRealEstateAgent(@PathVariable Long id, @RequestBody RealEstateAgent updatedRealEstateAgent) {
        RealEstateAgent existingRealEstateAgent = realEstateAgentService.getRealEstateAgentById(id);
        if (existingRealEstateAgent == null) {
            throw new ResourceNotFoundException("Real Estate Agent with Id not found " + id);
        }
        existingRealEstateAgent.setEmail(updatedRealEstateAgent.getEmail());
        existingRealEstateAgent.setPhone(updatedRealEstateAgent.getPhone());
        realEstateAgentService.createRealEstateAgent(existingRealEstateAgent);
        return existingRealEstateAgent;
    }
}
