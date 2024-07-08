package com.example.sb_ai_demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.sb_ai_demo.entities.Visit;

public interface VisitRepository extends JpaRepository<Visit, Integer> {

    @Query("SELECT v FROM Visit v " +
            "JOIN v.appointment.pet p " +
            "JOIN p.owner o " +
            "WHERE o.lastName = :lastName " +
            "ORDER BY v.appointment.date, v.appointment.time")
    List<Visit> findByOwnerLastName(@Param("lastName") String lastName);

    
}

