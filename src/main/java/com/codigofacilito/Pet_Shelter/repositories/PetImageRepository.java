package com.codigofacilito.Pet_Shelter.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codigofacilito.Pet_Shelter.models.pet_entities.PetImage;

@Repository
public interface PetImageRepository extends JpaRepository<PetImage, Long> {

    Optional<PetImage> findByPetId(Long petId);

    void deleteByPetId(Long petId);
    
}
