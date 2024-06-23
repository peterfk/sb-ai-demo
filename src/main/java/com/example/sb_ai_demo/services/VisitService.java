package com.example.sb_ai_demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sb_ai_demo.entities.Visit;
import com.example.sb_ai_demo.repositories.VisitRepository;

@Service
public class VisitService {
    
    @Autowired
    private VisitRepository visitRepository;
    
    public List<Visit> getAllVisits() {
        return visitRepository.findAll();
    }
    
    public Visit getVisitById(Integer id) {
        return visitRepository.findById(id).orElse(null);
    }
    
    public Visit saveVisit(Visit visit) {
        return visitRepository.save(visit);
    }
    
    public void deleteVisit(Integer id) {
        visitRepository.deleteById(id);
    }
}

