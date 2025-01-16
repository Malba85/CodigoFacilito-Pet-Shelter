package com.codigofacilito.Pet_Shelter.models.pet_entities;

public enum PetStatus {
    AVAILABLE("Available"),  //The pet is ready for adoption and actively looking for a home.
    UNAVAILABLE("Unavailable"),  //The pet is not available for adoption.
    UP4ADOPTION("Up for adoption"), //Pet is in the process of being adopted but has not yet been finalized
    ADOPTED("Adopted"); //The pet has been adopted and is no longer available.

    private final String status;

    PetStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
