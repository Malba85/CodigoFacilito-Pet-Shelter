package com.codigofacilito.Pet_Shelter.services.petServices;

import java.io.IOException;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.codigofacilito.Pet_Shelter.models.pet_entities.PetEntity;
import com.codigofacilito.Pet_Shelter.models.pet_entities.PetImage;
import com.codigofacilito.Pet_Shelter.repositories.PetImageRepository;
import com.codigofacilito.Pet_Shelter.repositories.PetRepository;

@Service
public class PetImageService {

    private final PetImageRepository petImageRepository;
    private final PetRepository petRepository;

    public PetImageService(PetImageRepository petImageRepository, PetRepository petRepository) {
        this.petImageRepository = petImageRepository;
        this.petRepository = petRepository;
    }

    public void savePetImage(Long petId, MultipartFile file) {
        Optional<PetEntity> petOpt = petRepository.findById(petId);
        if (petOpt.isEmpty()) {
            throw new IllegalArgumentException("Pet not found with ID: " + petId);
        }

        PetEntity pet = petOpt.get();

        try {
            PetImage petImage = new PetImage(file.getBytes(), file.getContentType(), pet);
            petImageRepository.save(petImage);
        } catch (IOException e) {
            throw new RuntimeException("Failed to store image", e);
        }
    }

    public PetImage getPetImageByPetId(Long petId) {
        return petImageRepository.findByPetId(petId)
                .orElseThrow(() -> new IllegalArgumentException("Image not found for pet ID: " + petId));
    }

    public void deletePetImage(Long petId) {
        petImageRepository.deleteByPetId(petId);
    }
}