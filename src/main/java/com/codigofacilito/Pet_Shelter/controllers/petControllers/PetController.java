package com.codigofacilito.Pet_Shelter.controllers.petControllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codigofacilito.Pet_Shelter.models.pet_entities.PetEntity;
import com.codigofacilito.Pet_Shelter.services.petServices.PetService;

@Controller
@RequestMapping("/pets")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    public String listPets(Model model) {
        List<PetEntity> pets = petService.getAllPets();
        model.addAttribute("pets", pets);
        return "pets/list"; // Redirige a "templates/pets/list.html"
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("pet", new PetEntity());
        return "pets/form"; // Muestra el formulario de registro de mascotas
    }

    @PostMapping("/save")
    public String savePet(@ModelAttribute PetEntity pet) {
        petService.savePet(pet);
        return "redirect:/pets";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        PetEntity pet = petService.getPetById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid pet ID:" + id));
        model.addAttribute("pet", pet);
        return "pets/form";
    }

    @PostMapping("/update/{id}")
    public String updatePet(@PathVariable Long id, @ModelAttribute PetEntity pet) {
        petService.updatePet(id, pet);
        return "redirect:/pets";
    }

    @GetMapping("/delete/{id}")
    public String deletePet(@PathVariable Long id) {
        petService.deletePet(id);
        return "redirect:/pets";
    }

    // listPets() → Muestra la lista de mascotas en una página (list.html).
    // showCreateForm() → Muestra un formulario vacío (form.html) para agregar una mascota.
    // savePet() → Guarda una nueva mascota y redirige a la lista.
    // showEditForm() → Carga los datos de una mascota para editarlos.
    // updatePet() → Guarda los cambios en una mascota.
    // deletePet() → Elimina una mascota.
}
