package com.example.sb_ai_demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sb_ai_demo.entities.Medication;
import com.example.sb_ai_demo.repositories.MedicationRepository;

@Service
public class MedicationService {
    
    @Autowired
    private MedicationRepository medicationRepository;
    
    public List<Medication> getAllMedications() {
        return medicationRepository.findAll();
    }
    
    public Medication getMedicationById(Integer id) {
        return medicationRepository.findById(id).orElse(null);
    }
    
    public Medication saveMedication(Medication medication) {
        return medicationRepository.save(medication);
    }
    
    public void deleteMedication(Integer id) {
        medicationRepository.deleteById(id);
    }
}

