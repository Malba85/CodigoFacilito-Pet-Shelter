package com.codigofacilito.Pet_Shelter.services.petServices;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codigofacilito.Pet_Shelter.models.pet_entities.PetEntity;
import com.codigofacilito.Pet_Shelter.repositories.PetRepository;

@Service
public class PetService {

    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<PetEntity> getAllPets() {
        return petRepository.findAll();
    }

    public Optional<PetEntity> getPetById(Long id) {
        return petRepository.findById(id);
    }

    public PetEntity savePet(PetEntity pet) {
        return petRepository.save(pet);
    }

    public PetEntity updatePet(Long id, PetEntity petDetails) {
        return petRepository.findById(id).map(pet -> {
            pet.setName(petDetails.getName());
            pet.setPetType(petDetails.getPetType());
            pet.setAge(petDetails.getAge());
            pet.setBreed(petDetails.getBreed());
            pet.setGender(petDetails.getGender());
            pet.setWeight(petDetails.getWeight());
            pet.setSize(petDetails.getSize());
            pet.setColor(petDetails.getColor());
            pet.setStatus(petDetails.getStatus());
            pet.setAdmissionDate(petDetails.getAdmissionDate());
            pet.setVaccines(petDetails.getVaccines());
            pet.setDeworming(petDetails.isDeworming());
            pet.setSterilization(petDetails.isSterilization());
            pet.setBehavior(petDetails.getBehavior());
            pet.setHistory(petDetails.getHistory());
            return petRepository.save(pet);
        }).orElseThrow(() -> new IllegalArgumentException("Pet not found with ID: " + id));
    }

    public void deletePet(Long id) {
        petRepository.deleteById(id);
    }
}