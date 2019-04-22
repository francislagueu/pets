package com.francislagueu.pets.models.pet;

public enum PetType {
    CAT("Cat"),
    DOG("Dog"),
    RABBIT("Rabbit");

    private String name;

    PetType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
