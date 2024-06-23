package com.example.sb_ai_demo.entities;


import java.util.Date;
import jakarta.persistence.*;


@Entity
@Table(name = "Vaccinations")
public class Vaccination {
    @Id
    private int vaccinationId;
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;
    private String vaccineType;
    private Date administrationDate;
    private Date expirationDate;
    public int getVaccinationId() {
        return vaccinationId;
    }
    public void setVaccinationId(int vaccinationId) {
        this.vaccinationId = vaccinationId;
    }
    public Pet getPet() {
        return pet;
    }
    public void setPet(Pet pet) {
        this.pet = pet;
    }
    public String getVaccineType() {
        return vaccineType;
    }
    public void setVaccineType(String vaccineType) {
        this.vaccineType = vaccineType;
    }
    public Date getAdministrationDate() {
        return administrationDate;
    }
    public void setAdministrationDate(Date administrationDate) {
        this.administrationDate = administrationDate;
    }
    public Date getExpirationDate() {
        return expirationDate;
    }
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    // getters and setters
}

