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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.sb_ai_demo.entities.Owner;
import com.example.sb_ai_demo.services.OwnerService;

@RestController
@RequestMapping("/api/owners")
public class OwnerController {
    
    @Autowired
    private OwnerService ownerService;
    
    @GetMapping
    public List<Owner> getAllOwners() {
        return ownerService.getAllOwners();
    }
    
    @GetMapping("/{id}")
    public Owner getOwnerById(@PathVariable Integer id) {
        return ownerService.getOwnerById(id);
    }
    
    @PostMapping
    public Owner createOwner(@RequestBody Owner owner) {
        return ownerService.saveOwner(owner);
    }
    
    @PutMapping("/{id}")
    public Owner updateOwner(@PathVariable Integer id, @RequestBody Owner owner) {
        return ownerService.saveOwner(owner);
    }
    
    @DeleteMapping("/{id}")
    public void deleteOwner(@PathVariable Integer id) {
        ownerService.deleteOwner(id);
    }

    @GetMapping("/testdata")
    public String createTestData() {
        ownerService.createTestData(); // Call createTestData method
        return "Test data created successfully";
    }

    @GetMapping("/search/{emailAddress}")
    public Owner getOwnerByEmail(@PathVariable String emailAddress) {
        return ownerService.getOwnerByEmail(emailAddress);
    }

    @GetMapping("/search/firstname-starts-with/{firstname}")
    public List<Owner> getOwnersByFirstnameStartsWith(@PathVariable String firstname) {
        return ownerService.getOwnersByFirstnameStartsWith(firstname);
    }

    @GetMapping("/search/lastname-or-firstname")
    public Owner getOwnerByLastnameOrFirstname(@RequestParam String lastname, @RequestParam String firstname) {
        return ownerService.getOwnerByLastnameOrFirstname(lastname, firstname);
    }
}

