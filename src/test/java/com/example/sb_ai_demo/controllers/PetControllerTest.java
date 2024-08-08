package com.example.sb_ai_demo.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;

import com.example.sb_ai_demo.entities.Owner;
import com.example.sb_ai_demo.entities.Pet;
import com.example.sb_ai_demo.repositories.PetRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PetControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private PetRepository petRepository;

    private String baseUrl;
    private RestClient restClient;

    @BeforeEach
    public void setUp() {
        baseUrl = "http://localhost:" + port + "/api/pets";
        restClient = RestClient.create(baseUrl);
    }

    @Test
    public void testGetAllPets() {

        List<Pet> pets = restClient.get()
                .retrieve().body(new ParameterizedTypeReference<>() {
                });

        assertEquals(11, pets.size());
    }

    @Test
    public void testGetPetById() {

        Pet pet = restClient.get().uri("/1").retrieve().body(Pet.class);

        assertEquals(1, pet.getPetId());

        int PetId = 1;

        ResponseEntity<Pet> resPet = restClient.get().uri("/{id}", PetId).retrieve()
                .toEntity(Pet.class);

        assertEquals(HttpStatus.OK, resPet.getStatusCode());
        assertNotNull(resPet.getBody());
        assertEquals(1, resPet.getBody().getPetId());
    }

    @Test
    public void testCreatePet() {

        Owner owner = new Owner();
        owner.setOwnerId(1);

        Pet newPet = new Pet("Fluffy", "Cat", "Persian", 3, 4.5, "Female", owner);

        // owner.setPets(new ArrayList<>(List.of(newPet)));

        Pet createdPet = restClient.post()
                .uri("/1")
                .contentType(MediaType.APPLICATION_JSON)
                .body(newPet)
                .retrieve()
                .body(Pet.class);

        assertNotNull(createdPet);
        assertTrue(createdPet.getPetId() > 0);
        assertEquals("Fluffy", createdPet.getName());

        int petId = createdPet.getPetId();

        // Delete the pet
        restClient.delete()
                .uri("/{id}", petId)
                .retrieve()
                .toBodilessEntity();
    }

    @Test
    public void testUpdatePet() {
        // First, create a pet
        Pet newPet = new Pet("Max", "Dog", "Golden Retriever", 4, 30.0, "Male", null);
        Pet createdPet = restClient.post()
                .uri("/1")
                .contentType(MediaType.APPLICATION_JSON)
                .body(newPet)
                .retrieve()
                .body(Pet.class);

        int petId = createdPet.getPetId();

        // Update the pet
        createdPet.setAge(5);
        createdPet.setWeight(32.5);

        Pet updatedPet = restClient.put()
                .uri("/1")
                .contentType(MediaType.APPLICATION_JSON)
                .body(createdPet)
                .retrieve()
                .body(Pet.class);

        assertNotNull(updatedPet);
        assertEquals(5, updatedPet.getAge());
        assertEquals(32.5, updatedPet.getWeight());

        // Delete the pet
        restClient.delete()
                .uri("/{id}", petId)
                .retrieve()
                .toBodilessEntity();
    }

}
