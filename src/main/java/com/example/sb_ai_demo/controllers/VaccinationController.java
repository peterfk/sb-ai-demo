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

import com.example.sb_ai_demo.entities.Vaccination;
import com.example.sb_ai_demo.services.VaccinationService;

@RestController
@RequestMapping("/api/vaccinations")
public class VaccinationController {
    
    @Autowired
    private VaccinationService vaccinationService;
    
    @GetMapping
    public List<Vaccination> getAllVaccinations() {
        return vaccinationService.getAllVaccinations();
    }
    
    @GetMapping("/{id}")
    public Vaccination getVaccinationById(@PathVariable Integer id) {
        return vaccinationService.getVaccinationById(id);
    }
    
    @PostMapping
    public Vaccination createVaccination(@RequestBody Vaccination vaccination) {
        return vaccinationService.saveVaccination(vaccination);
    }
    
    @PutMapping("/{id}")
    public Vaccination updateVaccination(@PathVariable Integer id, @RequestBody Vaccination vaccination) {
        return vaccinationService.saveVaccination(vaccination);
    }
    
    @DeleteMapping("/{id}")
    public void deleteVaccination(@PathVariable Integer id) {
        vaccinationService.deleteVaccination(id);
    }
}

