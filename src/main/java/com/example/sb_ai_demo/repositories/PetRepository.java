
package com.example.sb_ai_demo.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.sb_ai_demo.entities.Pet;

/**
 * This is the PetRepository interface that extends JpaRepository.
 * It provides methods to perform CRUD operations on Pet entities.
 * Additionally, it provides custom methods to find Pets by Owner ID, Name, and Species.
 */
public interface PetRepository extends JpaRepository<Pet, Integer> {

  /**
     * Find Pets by Owner ID.
     * @param ownerId The ID of the owner.
     * @return A list of Pets that belong to the owner with the given ID.
     * needs to travers Pets.owner and then Owner.ownerId
     */
    List<Pet> findByOwnerOwnerId(Integer ownerId);

    /**
     * Find Pets by Name.
     * @param name The name of the pet.
     * @return A list of Pets that have the given name.
     */
    List<Pet> findByName(String name);

    /**
     * Find Pets by Species.
     * @param species The species of the pet.
     * @return A list of Pets that belong to the given species.
     */
    List<Pet> findBySpecies(String species);
}
