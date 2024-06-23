package com.example.sb_ai_demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sb_ai_demo.entities.Medication;
import com.example.sb_ai_demo.services.MedicationService;

@RestController
@RequestMapping("/api/medications")
public class MedicationController {
    
    @Autowired
    private MedicationService medicationService;
    
    @GetMapping
    public List<Medication> getAllMedications() {
        return medicationService.getAllMedications();
    }
    
    @GetMapping("/{id}")
    public Medication getMedicationById(@PathVariable Integer id) {
        return medicationService.getMedicationById(id);
    }
    
    @PostMapping
    public Medication createMedication(@RequestBody Medication medication) {
        return medicationService.saveMedication(medication);
    }
    
    @PutMapping("/{id}")
    public Medication updateMedication(@PathVariable Integer id, @RequestBody Medication medication) {
        return medicationService.saveMedication(medication);
    }
    
    @DeleteMapping("/{id}")
    public void deleteMedication(@PathVariable Integer id) {
        medicationService.deleteMedication(id);
    }
}

