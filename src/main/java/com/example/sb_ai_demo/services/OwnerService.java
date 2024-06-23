package com.example.sb_ai_demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sb_ai_demo.entities.Owner;
import com.example.sb_ai_demo.repositories.OwnerRepository;

@Service
public class OwnerService {
    
    @Autowired
    private OwnerRepository ownerRepository;
    
    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }
    
    public Owner getOwnerById(Integer id) {
        return ownerRepository.findById(id).orElse(null);
    }
    
    public Owner saveOwner(Owner owner) {
        return ownerRepository.save(owner);
    }
    
    public void deleteOwner(Integer id) {
        ownerRepository.deleteById(id);
    }
}

