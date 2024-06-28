package com.example.sb_ai_demo.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name = "Labresults")
public class LabResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int labResultId;

    @ManyToOne
    @JoinColumn(name = "visit_id")
    @JsonManagedReference 
    private Visit visit;
    private String testName;
    private double result;
    private String units;
    private String referenceRange;

    public int getLabResultId() {
        return labResultId;
    }
    public void setLabResultId(int labResultId) {
        this.labResultId = labResultId;
    }
    public Visit getVisit() {
        return visit;
    }
    public void setVisit(Visit visit) {
        this.visit = visit;
    }
    public String getTestName() {
        return testName;
    }
    public void setTestName(String testName) {
        this.testName = testName;
    }
    public double getResult() {
        return result;
    }
    public void setResult(double result) {
        this.result = result;
    }
    public String getUnits() {
        return units;
    }
    public void setUnits(String units) {
        this.units = units;
    }
    public String getReferenceRange() {
        return referenceRange;
    }
    public void setReferenceRange(String referenceRange) {
        this.referenceRange = referenceRange;
    }

    // getters and setters
}

