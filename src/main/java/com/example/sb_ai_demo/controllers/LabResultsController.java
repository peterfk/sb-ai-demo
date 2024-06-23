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

import com.example.sb_ai_demo.entities.LabResult;
import com.example.sb_ai_demo.services.LabResultService;

@RestController
@RequestMapping("/api/labresults")
public class LabResultsController {

    @Autowired
    private LabResultService labResultService;

    @GetMapping
    public List<LabResult> getAllLabResults() {
        return labResultService.getAllLabResults();
    }

    // @GetMapping("/{labResultId}")
    // public LabResult getLabResult(@PathVariable int labResultId) {
    //     return labResultService.getLabResult(labResultId);
    // }

    // @PostMapping
    // public LabResult createLabResult(@RequestBody LabResult labResult) {
    //     return labResultService.createLabResult(labResult);
    // }

    // @PutMapping("/{labResultId}")
    // public LabResult updateLabResult(@PathVariable int labResultId, @RequestBody LabResult labResult) {
    //     return labResultService.updateLabResult(labResultId, labResult);
    // }

    @DeleteMapping("/{labResultId}")
    public void deleteLabResult(@PathVariable int labResultId) {
        labResultService.deleteLabResult(labResultId);
    }
}

