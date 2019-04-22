package com.francislagueu.pets.repositories.pet;

import com.francislagueu.pets.models.pet.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, String> {
}
