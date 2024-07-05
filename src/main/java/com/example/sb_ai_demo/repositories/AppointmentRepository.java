package com.example.sb_ai_demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.sb_ai_demo.entities.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    @Query("SELECT a FROM Appointment a " +
           "JOIN a.pet p " +
           "JOIN p.owner o " +
           "WHERE o.lastName = :lastName")
    List<Appointment> findByOwnerLastName(@Param("lastName") String lastName);
    
}

