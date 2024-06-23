package com.example.sb_ai_demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sb_ai_demo.entities.Pet;

public interface PetRepository extends JpaRepository<Pet, Integer> {
    
}

