package com.example.sb_ai_demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sb_ai_demo.entities.Owner;
import com.example.sb_ai_demo.repositories.OwnerRepository;

@Service
public class OwnerService {
    
    @Autowired
    private OwnerRepository ownerRepository;
    
    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }
    
    public Owner getOwnerById(Integer id) {
        return ownerRepository.findById(id).orElse(null);
    }
    
    public Owner saveOwner(Owner owner) {
        return ownerRepository.save(owner);
    }
    
    public void deleteOwner(Integer id) {
        ownerRepository.deleteById(id);
    }

    public Owner getOwnerByEmail(String emailAddress) {
        return ownerRepository.findByEmailAddress(emailAddress);
    }
    
    public List<Owner> getOwnersByFirstnameStartsWith(String firstname) {
        return ownerRepository.findByFirstnameStartsWith(firstname);
    }
    
    public List<Owner> getOwnerByLastnameOrFirstname(String lastname, String firstname) {
        return ownerRepository.findByLastnameOrFirstname(lastname, firstname);
    }

    public void createTestData() {
        Owner owner1 = new Owner();
        owner1.setFirstName("John");
        owner1.setLastName("Doe");
        owner1.setEmail("johndoe@example.com");
        owner1.setPhone("123-456-7890");
        owner1.setAddress("123 Main St");

        Owner owner2 = new Owner();
        owner2.setFirstName("Jane");
        owner2.setLastName("Smith");
        owner2.setEmail("janesmith@example.com");
        owner2.setPhone("098-765-4321");
        owner2.setAddress("456 Elm St");

        Owner owner3 = new Owner();
        owner3.setFirstName("Robert");
        owner3.setLastName("Johnson");
        owner3.setEmail("robertjohnson@example.com");
        owner3.setPhone("555-123-4567");
        owner3.setAddress("789 Oak St");

        Owner owner4 = new Owner();
        owner4.setFirstName("Mary");
        owner4.setLastName("Williams");
        owner4.setEmail("marywilliams@example.com");
        owner4.setPhone("321-098-7654");
        owner4.setAddress("321 Pine St");

        Owner owner5 = new Owner();
        owner5.setFirstName("David");
        owner5.setLastName("Davis");
        owner5.setEmail("daviddavis@example.com");
        owner5.setPhone("654-321-0987");
        owner5.setAddress("901 Maple St");

        ownerRepository.save(owner1);
        ownerRepository.save(owner2);
        ownerRepository.save(owner3);
        ownerRepository.save(owner4);
        ownerRepository.save(owner5);
    }
}


