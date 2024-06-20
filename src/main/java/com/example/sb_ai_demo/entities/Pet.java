package com.example.sb_ai_demo.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "owner", nullable = false, length = 20)
    private String owner;

    @Column(name = "species", nullable = false, length = 20)
    private String species;

    @Column(name = "sex", nullable = false, length = 1)
    private String sex;

    @Column(name = "birth", nullable = false)
    private java.sql.Date birth;

    @Column(name = "death", nullable = true)
    private java.sql.Date death;

    public Pet(String name, String owner, String species, String string, Date birth) {
        this.name = name;
        this.owner = owner;
        this.species = species;
        this.sex = string;
        this.birth = birth;
    }

    public Pet() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public java.sql.Date getBirth() {
        return birth;
    }

    public void setBirth(java.sql.Date birth) {
        this.birth = birth;
    }

    public java.sql.Date getDeath() {
        return death;
    }

    public void setDeath(java.sql.Date death) {
        this.death = death;
    }
}
