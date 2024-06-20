package com.example.sb_ai_demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sb_ai_demo.entities.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {

    List<Pet> findByOwner(String owner);

    Pet findByIdAndSpecies(Long id, String species);

    List<Pet> findByName(String name);

}
