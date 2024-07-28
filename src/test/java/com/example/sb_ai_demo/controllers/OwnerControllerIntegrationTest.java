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
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        assertEquals(1, response.getBody().getOwnerId());
    }

    // Add more tests for other methods in a similar manner
    @Test
    public void testGetOwnerById2() throws Exception {
        int ownerId = 1; // assume owner with id 1 exists
        ResponseEntity<Owner> response = restTemplate.getForEntity("/api/owners/{id}", Owner.class, ownerId);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertNotNull(response.getBody());
        assertEquals(ownerId, response.getBody().getOwnerId());
    }

    @Test
    public void testCreateOwner() throws Exception {
        Owner owner = new Owner();
        owner.setFirstName("John");
        owner.setLastName("Doe2");
        owner.setEmail("john.doe4@example.com");
        owner.setPhone("1234567890");
        owner.setAddress("123 Main St, City, State, Zip");
        ResponseEntity<Owner> response = restTemplate.postForEntity("/api/owners", owner, Owner.class);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertNotNull(response.getBody());
        assertEquals(owner.getFirstName(), response.getBody().getFirstName());
        assertEquals(owner.getLastName(), response.getBody().getLastName());
        assertEquals(owner.getEmail(), response.getBody().getEmail());

        // detele the owner
        restTemplate.delete("/api/owners/{id}", response.getBody().getOwnerId());
        // ResponseEntity<String> response =
        // restTemplate.getForEntity("/api/owners/{id}", String.class, ownerId);
        // assertThat(response.getStatusCode(), equalTo(HttpStatus.NOT_FOUND));
    }

    @Test
    public void testGetOwnerByEmail() throws Exception {
        String email = "john.doe@example.com"; // assume owner with email exists
        ResponseEntity<Owner> response = restTemplate.getForEntity("/api/owners/search/{emailAddress}", Owner.class,
                email);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertNotNull(response.getBody());
        assertEquals(email, response.getBody().getEmail());
    }

    @Test
    public void testUpdateOwner() {
        Owner owner = new Owner();
        owner.setOwnerId(1);
        owner.setFirstName("Jane");
        owner.setLastName("Doe");
        owner.setEmail("jane.doe@example.com");
        owner.setPhone("9876543210");
        owner.setAddress("456 Elm St");

        restTemplate.put("/api/owners/{id}", owner, 1);
    }

    @Test
    public void testGetOwnersByFirstnameStartsWith() {
        String firstname = "J";
        ResponseEntity<List<Owner>> response = restTemplate.exchange(
                "/api/owners/search/firstname-starts-with/{firstname}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Owner>>() {
                },
                firstname);

        // assert the response status code and body
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().size() > 0);
        for (Owner owner : response.getBody()) {
            assertTrue(owner.getFirstName().startsWith(firstname));
        }

    }

    @Test
    public void testGetOwnerByLastnameOrFirstname() {
        System.out.println("URL: is ??????? ");
        Owner owner = new Owner();
        owner.setLastName("Doe2");
        owner.setFirstName("Jane");

        String url = "/api/owners/search/lastname-or-firstname?lastname={lastname}&firstname={firstname}";
        Map<String, String> params = new HashMap<>();
        params.put("lastname", owner.getLastName());
        params.put("firstname", owner.getFirstName());

        ResponseEntity<List<Owner>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Owner>>() {
                },
                params);

        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        assertNotNull(responseEntity.getBody());

        List<Owner> owners = responseEntity.getBody();
        assertEquals(4, owners.size());

    }

}
