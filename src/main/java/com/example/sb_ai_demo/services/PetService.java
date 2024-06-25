package com.example.sb_ai_demo.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sb_ai_demo.entities.Owner;
import com.example.sb_ai_demo.entities.Pet;
import com.example.sb_ai_demo.repositories.OwnerRepository;
import com.example.sb_ai_demo.repositories.PetRepository;

@Service
public class PetService {
    
    @Autowired
    private PetRepository petRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    
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

    public void createPets() {
        // Get existing owners
        List<Owner> owners = ownerRepository.findAllById(Arrays.asList(1, 2, 3, 4, 5));

        // Create 10 pets
        List<Pet> pets = Arrays.asList(
                new Pet("Fido", "Dog", "Golden Retriever", 3, 20.0, "Male", owners.get(0)),
                new Pet("Whiskers", "Cat", "Siamese", 2, 10.0, "Female", owners.get(1)),
                new Pet("Buddy", "Dog", "Labrador", 5, 30.0, "Male", owners.get(2)),
                new Pet("Mittens", "Cat", "Persian", 4, 15.0, "Female", owners.get(3)),
                new Pet("Rufus", "Dog", "Beagle", 6, 25.0, "Male", owners.get(4)),
                new Pet("Luna", "Cat", "Maine Coon", 3, 12.0, "Female", owners.get(0)),
                new Pet("Rocky", "Dog", "Boxer", 7, 28.0, "Male", owners.get(1)),
                new Pet("Ginger", "Cat", "Ginger", 5, 18.0, "Female", owners.get(2)),
                new Pet("Duke", "Dog", "German Shepherd", 8, 35.0, "Male", owners.get(3)),
                new Pet("Sophie", "Cat", "Ragdoll", 6, 20.0, "Female", owners.get(4))
        );
        petRepository.saveAll(pets);
    }
}

