package com.codigofacilito.Pet_Shelter.models.pet_entities;

public enum PetGender {
    MALE("male"),
    FEMALE("female");

    private final String gender;

    private PetGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
