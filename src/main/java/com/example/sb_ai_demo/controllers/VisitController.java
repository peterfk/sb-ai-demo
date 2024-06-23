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
import org.springframework.web.bind.annotation.RestController;

import com.example.sb_ai_demo.entities.Visit;
import com.example.sb_ai_demo.services.VisitService;

@RestController
@RequestMapping("/api/visits")
public class VisitController {

    @Autowired
    private VisitService visitService;

    @GetMapping
    public List<Visit> getAllVisits() {
        return visitService.getAllVisits();
    }

    // @GetMapping("/{visitId}")
    // public Visit getVisit(@PathVariable int visitId) {
    //     return visitService.getVisit(visitId);
    // }

    // @PostMapping
    // public Visit createVisit(@RequestBody Visit visit) {
    //     return visitService.createVisit(visit);
    // }

    // @PutMapping("/{visitId}")
    // public Visit updateVisit(@PathVariable int visitId, @RequestBody Visit visit) {
    //     return visitService.updateVisit(visitId, visit);
    // }

    @DeleteMapping("/{visitId}")
    public void deleteVisit(@PathVariable int visitId) {
        visitService.deleteVisit(visitId);
    }
}

