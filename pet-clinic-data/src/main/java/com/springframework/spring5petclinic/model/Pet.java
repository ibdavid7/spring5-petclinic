package com.springframework.spring5petclinic.model;

import java.time.LocalDate;

public class Pet extends NamedEntity {

    private PetType petType;
    private Owner owner;
    private LocalDate birthDate;

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id='" + this.getId() + '\'' +
                ", name='" + this.getName() + '\'' +
                ", petType=" + petType +
//                ", owner=" + owner +  //Causing StackOverflow if called form Owner toString()
                ", birthDate=" + birthDate +
                '}';
    }
}
