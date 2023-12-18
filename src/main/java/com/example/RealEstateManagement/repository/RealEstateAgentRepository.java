package com.example.RealEstateManagement.repository;

import com.example.RealEstateManagement.model.RealEstateAgent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealEstateAgentRepository extends JpaRepository<RealEstateAgent,Long> {
}
