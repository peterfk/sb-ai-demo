package com.example.sb_ai_demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Imaging")
public class Imaging {
    @Id
    private int imagingId;
    @ManyToOne
    @JoinColumn(name = "visit_id")
    private Visit visit;
    private String studyType;
    private String imageUrl;
    public int getImagingId() {
        return imagingId;
    }
    public void setImagingId(int imagingId) {
        this.imagingId = imagingId;
    }
    public Visit getVisit() {
        return visit;
    }
    public void setVisit(Visit visit) {
        this.visit = visit;
    }
    public String getStudyType() {
        return studyType;
    }
    public void setStudyType(String studyType) {
        this.studyType = studyType;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    // getters and setters
}

