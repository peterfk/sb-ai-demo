package com.example.sb_ai_demo.controllers;

import com.example.sb_ai_demo.entities.Owner;
import com.example.sb_ai_demo.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OwnerControllerTest {

    @Mock
    private OwnerService ownerService;

    @InjectMocks
    private OwnerController ownerController;

    @BeforeEach
    public void setup() {
        // MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllOwners() {
        Owner owner = new Owner();
        owner.setOwnerId(1);
        owner.setFirstName("John");
        owner.setLastName("Doe");
        owner.setEmail("john.doe@example.com");

        List<Owner> owners = Collections.singletonList(owner);

        when(ownerService.getAllOwners()).thenReturn(owners);

        List<Owner> result = ownerController.getAllOwners();

        assertEquals(owners, result);
        verify(ownerService, times(1)).getAllOwners();
    }

    @Test
    public void testGetAllOwners_EmptyList() {
        when(ownerService.getAllOwners()).thenReturn(Collections.emptyList());

        List<Owner> result = ownerController.getAllOwners();

        assertEquals(Collections.emptyList(), result);
        verify(ownerService, times(1)).getAllOwners();
    }

    @Test
    public void testGetOwnerById() {
        Owner owner = new Owner();
        owner.setOwnerId(1);
        owner.setFirstName("John");
        owner.setLastName("Doe");
        owner.setEmail("john.doe@example.com");

        when(ownerService.getOwnerById(1)).thenReturn(owner);

        Owner result = ownerController.getOwnerById(1);

        assertEquals(owner, result);
        verify(ownerService, times(1)).getOwnerById(1);
    }

    // Add more tests for other methods in a similar manner
}

