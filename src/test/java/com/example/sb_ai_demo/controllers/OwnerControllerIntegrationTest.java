package com.example.sb_ai_demo.controllers;

import com.example.sb_ai_demo.entities.Owner;
import com.example.sb_ai_demo.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OwnerControllerIntegrationTest {

    Logger logger = LoggerFactory.getLogger(OwnerControllerIntegrationTest.class);

    @LocalServerPort
    private int port;

    private String baseUrl = "http://localhost:";

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private OwnerRepository ownerRepository;

    @BeforeEach
    public void setup() {
        // ownerRepository.deleteAll();
    }

    @SuppressWarnings("null")
    @Test
    public void testGetAllOwners() {

        logger.warn("testGetAllOwners");
        String url = baseUrl + port + "/api/owners";
        logger.warn("url: " + url);
        logger.warn("port: " + port);

        Owner owner1 = new Owner();
        owner1.setFirstName("John");
        owner1.setLastName("Doe2");
        owner1.setEmail("john.doe@example.com");
        owner1.setPhone("1234567890");
        owner1.setAddress("123 Main St, City, State, Zip");

        Owner owner2 = new Owner();
        owner2.setFirstName("Jane");
        owner2.setLastName("Doe2");
        owner2.setEmail("jane.doe@example.com");
        owner2.setPhone("0987654321");
        owner2.setAddress("456 Elm St, Town, State, Zip");

        // ownerRepository.saveAll(Arrays.asList(owner1, owner2));

        ResponseEntity<Owner[]> response = restTemplate.getForEntity(url, Owner[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(7, response.getBody().length);
    }

    @Test
    public void testGetOwnerById() {
        Owner owner = new Owner();
        owner.setFirstName("John");
        owner.setLastName("Doe");
        owner.setEmail("john.doe@example.com");

        // owner = ownerRepository.save(owner);

        ResponseEntity<Owner> response = restTemplate.getForEntity("/api/owners/1", Owner.class, owner.getOwnerId());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        // assertEquals(owner.getOwnerId(), response.getBody().getOwnerId());
    }

    // Add more tests for other methods in a similar manner
}
