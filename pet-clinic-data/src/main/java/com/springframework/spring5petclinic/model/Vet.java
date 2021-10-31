package com.springframework.spring5petclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vets")
public class Vet extends Person {

    @Builder
    public Vet(Long id, String firstName, String lastName) {
        super(id, firstName, lastName);
//        this.specialties = specialties; interferes with Instance Initialization Block IIB
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "vet_speciality",
            joinColumns = @JoinColumn(name = "vet_id"),
            inverseJoinColumns = @JoinColumn(name = "speciality_id")
    )
    private Set<Specialty> specialties;

    {
        specialties = new HashSet<>();
    }

    public void addSpecialty(Specialty specialty) {
//        if (this.specialties == null) this.specialties = new HashSet<>(); No longer Require as Constructor was
//        fixed to exclude speciality set
        this.specialties.add(specialty);
    }

    @Override
    public String toString() {
        return "Vet{" +
                "id='" + this.getId() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", specialties=" + specialties +
                '}';
    }
}
