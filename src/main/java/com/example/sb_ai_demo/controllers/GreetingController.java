package com.example.sb_ai_demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.sb_ai_demo.entities.Pet;
import com.example.sb_ai_demo.services.PetService;

@RestController
public class GreetingController {

    @Autowired
    private PetService petService;

    @GetMapping("/")
    /**
     * Returns a greeting message for the home page.
     *
     * @return A string representing the home page greeting.
     */
    public String home() {
        return "Home Page";
    }

    /**
     * Returns a simple greeting message.
     *
     * @return A string representing a basic greeting.
     */
    @GetMapping("/greet")
    public String greet() {
        return "Hello World!";
    }

    /**
     * Returns a personalized greeting message with a specified name.
     *
     * @param name The name to include in the greeting (defaults to 'World' if not
     *             provided).
     * @return A string representing a customized greeting.
     */
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/insert")
    public String insert() {

        // insert data into DB
        petService.savePets();

        return "Saved new Pets";
    }

    @GetMapping("/findpets")
    public List<Pet> searchPets(@RequestParam(name = "name", required = false) String name) {
        List<Pet> pets = new ArrayList<>();
        if (name != null && !name.isEmpty()) {
            pets = petService.searchPetsByName(name);
        } else {
            // return all pets if no name is provided
            pets = petService.getAllPets();
        }
        return pets;
    }

    @GetMapping("/owners/{ownerName}")
    public List<Pet> getPetsByOwnerName(@PathVariable String ownerName) {
        return petService.getPetsByOwnerName(ownerName);
    }

}
