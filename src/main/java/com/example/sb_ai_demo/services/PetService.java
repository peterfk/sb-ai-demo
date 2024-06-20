package com.example.sb_ai_demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sb_ai_demo.entities.Pet;
import com.example.sb_ai_demo.repositories.PetRepository;

@Service
public class PetService  {

    @Autowired
    private PetRepository petRepository;

    public void savePets()  {
        Pet pet1 = new Pet("Fido", "John Doe", "Dog", "M", java.sql.Date.valueOf("2020-01-01"));
        Pet pet2 = new Pet("Whiskers", "Jane Smith", "Cat", "F", java.sql.Date.valueOf("2019-06-15"));
        Pet pet3 = new Pet("Goldie", "Bob Johnson", "Bird", "M", java.sql.Date.valueOf("2020-03-20"));

        petRepository.save(pet1);
        petRepository.save(pet2);
        petRepository.save(pet3);

        System.out.println("Pets saved successfully!");
    }

    public List<Pet> getAllPets() {
        
        return petRepository.findAll();
    }

    public List<Pet> searchPetsByName(String name) {
        
        return petRepository.findByName(name);
    }

    public List<Pet> getPetsByOwnerName(String ownerName) {
        return petRepository.findByOwner(ownerName);
    }
}
