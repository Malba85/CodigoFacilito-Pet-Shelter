package com.codigofacilito.Pet_Shelter.controllers.petControllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.codigofacilito.Pet_Shelter.services.petServices.PetImageService;

@Controller
@RequestMapping("/pets/images")
public class PetImageController {

    private final PetImageService petImageService;

    public PetImageController(PetImageService petImageService) {
        this.petImageService = petImageService;
    }

    @GetMapping("/{petId}")
    public String showImageForm(@PathVariable Long petId, Model model) {
        model.addAttribute("petId", petId);
        return "pets/image-form"; // Muestra el formulario de carga de imagen
    }

    @PostMapping("/upload/{petId}")
    public String uploadImage(@PathVariable Long petId, @RequestParam("file") MultipartFile file) {
        //petImageService.savePetImage(petId, file);
        return "redirect:/pets";
    }

    @GetMapping("/view/{petId}")
    @ResponseBody
    public byte[] viewImage(@PathVariable Long petId) {
        return petImageService.getPetImageByPetId(petId).getImageData();
    }

    // showImageForm() → Muestra un formulario para cargar imágenes (image-form.html).
    // uploadImage() → Recibe una imagen desde un formulario y la guarda en la BD.
    // viewImage() → Devuelve la imagen como byte[] para mostrarla en la vista.
}