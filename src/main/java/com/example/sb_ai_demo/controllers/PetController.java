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

import com.example.sb_ai_demo.entities.Owner;
import com.example.sb_ai_demo.entities.Pet;
import com.example.sb_ai_demo.services.PetService;

@RestController
@RequestMapping("/api/pets")
public class PetController {
    
    @Autowired
    private PetService petService;
    
    @GetMapping
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }
    
    @GetMapping("/{id}")
    public Pet getPetById(@PathVariable Integer id) {
        return petService.getPetById(id);
    }
    
    @PostMapping("/{id}")
    public Pet createPet(@PathVariable Integer id, @RequestBody Pet pet) {
        Owner owner = new Owner();
        owner.setOwnerId(id);
        pet.setOwner(owner);
        return petService.savePet(pet);
    }
    
    @PutMapping("/{id}")
    public Pet updatePet(@PathVariable Integer id, @RequestBody Pet pet) {
        Owner owner = new Owner();
        owner.setOwnerId(id);
        pet.setOwner(owner);
        return petService.savePet(pet);
    }
    
    @DeleteMapping("/{id}")
    public void deletePet(@PathVariable Integer id) {
        petService.deletePet(id);
    }

    @PostMapping("/create-pets")
    public void createMultiplePets() {
        petService.createPets();
    }
}

