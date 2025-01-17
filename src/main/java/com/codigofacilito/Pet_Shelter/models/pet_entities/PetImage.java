package com.codigofacilito.Pet_Shelter.models.pet_entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;

@Entity
public class PetImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column(columnDefinition = "LONGBLOB") Para MySQL
    @Lob
    private byte[] imageData;

    private String contentType; // Ejemplo: "image/png", "image/jpeg"

    @OneToOne
    @JoinColumn(name = "pet_id", nullable = false)
    private PetEntity pet;

    // Constructores

    public PetImage() {}

    public PetImage(byte[] imageData, String contentType, PetEntity pet) {
        this.imageData = imageData;
        this.contentType = contentType;
        this.pet = pet;
    }
    
    // Getters y Setters
    public Long getId() {
        return id;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public PetEntity getPet() {
        return pet;
    }

    public void setPet(PetEntity pet) {
        this.pet = pet;
    }
}
