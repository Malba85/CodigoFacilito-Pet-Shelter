package com.codigofacilito.Pet_Shelter.models.pet_entities;

public enum PetSize {
    SMALL("small"), 
    MEDIUM("medium"), 
    LARGE("large");

    private final String size;

    PetSize(String size) {
        this.size = size;
    }
     
    public String getSize() {
        return size;
    }
}
