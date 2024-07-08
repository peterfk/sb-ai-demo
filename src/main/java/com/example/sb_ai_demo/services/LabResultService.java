package com.example.sb_ai_demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sb_ai_demo.entities.LabResult;
import com.example.sb_ai_demo.repositories.LabResultRepository;

@Service
public class LabResultService {
    
    @Autowired
    private LabResultRepository labResultRepository;
    
    public List<LabResult> getAllLabResults() {
        return labResultRepository.findAll();
    }
    
    public LabResult getLabResultById(Integer id) {
        return labResultRepository.findById(id).orElse(null);
    }
    
    public LabResult saveLabResult(LabResult labResult) {
        return labResultRepository.save(labResult);
    }

    public LabResult getLabResult(int labResultId) {
        return labResultRepository.findById(labResultId).orElse(null);
    }

    public LabResult createLabResult(LabResult labResult) {
        return labResultRepository.save(labResult);
    }

    public LabResult updateLabResult(LabResult labResult) {
        return labResultRepository.save(labResult);
    }
    
    public void deleteLabResult(Integer id) {
        labResultRepository.deleteById(id);
    }
}

