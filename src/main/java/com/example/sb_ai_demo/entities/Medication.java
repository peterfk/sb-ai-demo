package com.example.sb_ai_demo.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Medications")
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int medicationId;
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;
    private String medicationName;
    private String dosage;
    private String administrationMethod;
    private Date startDate;
    private Date endDate;

    public int getMedicationId() {
        return medicationId;
    }

    public void setMedicationId(int medicationId) {
        this.medicationId = medicationId;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getAdministrationMethod() {
        return administrationMethod;
    }

    public void setAdministrationMethod(String administrationMethod) {
        this.administrationMethod = administrationMethod;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    // getters and setters
}
