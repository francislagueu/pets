package com.francislagueu.pets.controllers.pet;

import com.francislagueu.pets.models.pet.Pet;
import com.francislagueu.pets.repositories.pet.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class PetController {

    @Autowired
    PetRepository petRepository;

    @GetMapping("/pets")
    public List<Pet> getAllPets(){
        Sort sort = new Sort(Sort.Direction.DESC, "createdAt");
        return petRepository.findAll(sort);
    }

    @GetMapping(value = "/pets/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable("id") String id){
        return petRepository.findById(id)
                .map(pet -> ResponseEntity.ok().body(pet))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/pets")
    public Pet createPet(@Valid @RequestBody Pet pet){
        return petRepository.save(pet);
    }

    @PutMapping(value = "/pets/{id}")
    public ResponseEntity<Pet> updatePet(@PathVariable("id") String id, @Valid @RequestBody Pet pet){
        return petRepository.findById(id)
                .map(petData -> {
                    petData.setName(pet.getName());
                    petData.setAge(pet.getAge());
                    petData.setBio(pet.getBio());
                    petData.setBreed(pet.getBreed());
                    petData.setType(pet.getType());
                    Pet updatedPet  = petRepository.save(petData);
                    return ResponseEntity.ok().body(updatedPet);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/pets/{id}")
    public ResponseEntity<?> deletePet(@PathVariable("id") String id){
        return petRepository.findById(id)
                .map(pet->{
                    petRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
