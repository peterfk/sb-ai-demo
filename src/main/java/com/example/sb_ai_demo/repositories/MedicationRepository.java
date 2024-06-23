package com.example.sb_ai_demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sb_ai_demo.entities.Medication;

public interface MedicationRepository extends JpaRepository<Medication, Integer> {
    
}

