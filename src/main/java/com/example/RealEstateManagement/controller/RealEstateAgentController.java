package com.example.RealEstateManagement.controller;

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
    public List<RealEstateAgent> getAllRealEstateAgent(){
        return  realEstateAgentService.getAllRealEstateAgent();
    }

    @PostMapping
    public RealEstateAgent addRealEstateAgent (@RequestBody RealEstateAgent property) {
        return realEstateAgentService.createRealEstateAgent(property);
    }

    @DeleteMapping("/{id}")
    public void deleteRealEstateAgent(@PathVariable Long id) {
        realEstateAgentService.deleteRealEstateAgent(id);
    }

}
