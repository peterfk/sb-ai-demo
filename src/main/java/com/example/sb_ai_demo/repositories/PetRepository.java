package com.example.sb_ai_demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sb_ai_demo.entities.Pet;

public interface PetRepository extends JpaRepository<Pet, Integer> {

    List<Pet> findByOwnerId(Integer ownerId);

    List<Pet> findByName(String name);

    // Find Pets by Species
    List<Pet> findBySpecies(String species);
    
}

