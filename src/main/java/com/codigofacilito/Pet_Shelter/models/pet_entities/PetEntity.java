package com.codigofacilito.Pet_Shelter.models.pet_entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class PetEntity {

    private @Id @GeneratedValue Long id; // Unique identifier

    @NotNull(message = "The name cannot be null")
    @Size(min = 2, message = "The name must have at least 2 character")
    private String name; // Name of the pet

    // Enum representing the type of pet (no relationship here)
    @Enumerated(EnumType.STRING) // Store enum as a string in the database
    @NotNull(message = "Type of pet cannot be null")
    private PetType petType; // Reference to the PetType enum

    @Min(0)
    @Max(30)
    private Integer age; // Age of the pet in years

    @NotNull(message = "Availability status must be specified")
    private Boolean available; // Availability status for adoption

    private String Breed;  //The breed of the pet (if applicable). For example, "Golden Retriever"

    @Enumerated(EnumType.STRING) // Store enum as a string in the database
    @NotNull(message = "Gender of pet cannot be null")
    private PetGender petGender; 

    private double Weight;  //The weight of the pet in kilograms
    
    @Enumerated(EnumType.STRING) // Store enum as a string in the database
    private PetSize petSize;  

    private String Color;  //The color of the pet. For example, "Black"

    @Enumerated(EnumType.STRING)
    private PetStatus petStatus;  //The status of the pet. For example, "Available"

    private LocalDate AdmissionDate;  // The date the pet was admitted to the shelter.

    @ElementCollection
    private List<String> vaccines;  // A list of vaccines administered to the pet.

    private boolean deworming;  //Whether the pet has been dewormed.
    
    private boolean sterilization;  //Whether the pet has been sterilized.

    @Column(columnDefinition = "TEXT")
    private String behavior;  //Notes on the pet's behavior (e.g., sociable, shy, playful).

    @Column(columnDefinition = "TEXT")
    private String history;  //The pet's history (e.g., rescued from the street, any relevant incidents).

    @OneToOne(mappedBy = "pet", cascade = CascadeType.ALL)
    private PetImage petImage;

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

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getBreed() {
        return Breed;
    }

    public void setBreed(String breed) {
        Breed = breed;
    }

    public PetGender getGender() {
        return petGender;
    }

    public void setGender(PetGender petGender) {
        this.petGender = petGender;
    }

    public double getWeight() {
        return Weight;
    }

    public void setWeight(double weight) {
        Weight = weight;
    }

    public PetSize getSize() {
        return petSize;
    }

    public void setSize(PetSize petSize) {
        this.petSize = petSize;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public PetStatus getStatus() {
        return petStatus;
    }

    public void setStatus(PetStatus petStatus) {
        this.petStatus = petStatus;
    }

    public LocalDate getAdmissionDate() {
        return AdmissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        AdmissionDate = admissionDate;
    }

    public List<String> getVaccines() {
        return vaccines;
    }

    public void setVaccines(List<String> vaccines) {
        this.vaccines = vaccines;
    }

    public boolean isDeworming() {
        return deworming;
    }

    public void setDeworming(boolean deworming) {
        this.deworming = deworming;
    }

    public boolean isSterilization() {
        return sterilization;
    }

    public void setSterilization(boolean sterilization) {
        this.sterilization = sterilization;
    }

    public String getBehavior() {
        return behavior;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public PetImage getImage() {
        return petImage;
    }

    public void setImage(PetImage petImage) {
        this.petImage = petImage;
    }
}