package com.francislagueu.pets.models.pet;

import com.francislagueu.pets.models.pet.audit.AuditModel;
import com.francislagueu.pets.models.user.User;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "pet")
public class Pet extends AuditModel {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "age")
    private int age;

    @NotNull
    @Column(name = "breed")
    private String breed;

    @Column(name = "bio")
    private String bio;

    @NotNull
    @Column(name = "type")
    private String type;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User owner;

    public Pet() {
    }

    public Pet(@NotNull String name, @NotNull int age, @NotNull String breed, String bio, @NotNull String type) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.bio = bio;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", breed='" + breed + '\'' +
                ", bio='" + bio + '\'' +
                ", type=" + type +
                '}';
    }
}
