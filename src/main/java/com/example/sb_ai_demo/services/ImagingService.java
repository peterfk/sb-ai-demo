package com.example.sb_ai_demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sb_ai_demo.entities.Imaging;
import com.example.sb_ai_demo.repositories.ImagingRepository;

@Service
public class ImagingService {
    
    @Autowired
    private ImagingRepository imagingRepository;
    
    public List<Imaging> getAllImagings() {
        return imagingRepository.findAll();
    }
    
    public Imaging getImagingById(Integer id) {
        return imagingRepository.findById(id).orElse(null);
    }
    
    public Imaging saveImaging(Imaging imaging) {
        return imagingRepository.save(imaging);
    }

    public Imaging updateImaging(Integer id, Imaging imaging) {
        Imaging existingImaging = imagingRepository.findById(id).orElse(null);
        if (existingImaging != null) {
            imaging.setImagingId(id);
            return imagingRepository.save(imaging);
        }
        return null;
    }
    
    public void deleteImaging(Integer id) {
        imagingRepository.deleteById(id);
    }
}

