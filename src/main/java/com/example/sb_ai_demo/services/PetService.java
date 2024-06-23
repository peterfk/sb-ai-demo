package com.example.sb_ai_demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sb_ai_demo.entities.Pet;
import com.example.sb_ai_demo.repositories.PetRepository;

@Service
public class PetService {
    
    @Autowired
    private PetRepository petRepository;
    
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }
    
    public Pet getPetById(Integer id) {
        return petRepository.findById(id).orElse(null);
    }
    
    public Pet savePet(Pet pet) {
        return petRepository.save(pet);
    }
    
    public void deletePet(Integer id) {
        petRepository.deleteById(id);
    }
}

