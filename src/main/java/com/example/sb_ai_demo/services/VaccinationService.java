package com.example.sb_ai_demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sb_ai_demo.entities.Vaccination;
import com.example.sb_ai_demo.repositories.VaccinationRepository;

@Service
public class VaccinationService {
    
    @Autowired
    private VaccinationRepository vaccinationRepository;
    
    public List<Vaccination> getAllVaccinations() {
        return vaccinationRepository.findAll();
    }
    
    public Vaccination getVaccinationById(Integer id) {
        return vaccinationRepository.findById(id).orElse(null);
    }
    
    public Vaccination saveVaccination(Vaccination vaccination) {
        return vaccinationRepository.save(vaccination);
    }
    
    public void deleteVaccination(Integer id) {
        vaccinationRepository.deleteById(id);
    }
}

