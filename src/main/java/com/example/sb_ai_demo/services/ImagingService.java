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
    
    public void deleteImaging(Integer id) {
        imagingRepository.deleteById(id);
    }
}

