package com.example.RealEstateManagement.service;

import com.example.RealEstateManagement.model.RealEstateAgent;
import com.example.RealEstateManagement.repository.RealEstateAgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RealEstateAgentService {
    @Autowired
    private RealEstateAgentRepository realEstateAgentRepository;

    public List<RealEstateAgent> getAllRealEstateAgent() {
        return realEstateAgentRepository.findAll();
    }

    public RealEstateAgent createRealEstateAgent(RealEstateAgent realEstateAgent) {
        return realEstateAgentRepository.save(realEstateAgent);
    }

    public void deleteRealEstateAgent(Long id) {
        realEstateAgentRepository.deleteById(id);
    }
    public RealEstateAgent getRealEstateAgentById(Long id) {
        return realEstateAgentRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("RealEstateAgent not found with ID: " + id)
        );
    }
    public void updateRealEstateAgent(RealEstateAgent realEstateAgent) {
        realEstateAgentRepository.save(realEstateAgent);
    }
}
