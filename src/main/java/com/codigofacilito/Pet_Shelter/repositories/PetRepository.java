package com.codigofacilito.Pet_Shelter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codigofacilito.Pet_Shelter.models.pet_entities.PetEntity;

@Repository
public interface PetRepository extends JpaRepository<PetEntity, Long> {
    
}
