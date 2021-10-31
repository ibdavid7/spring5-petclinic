package com.springframework.spring5petclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pets")
public class Pet extends NamedEntity {

    @Builder
    public Pet(Long Id, String name, PetType petType, Owner owner, LocalDate birthDate) {
        super(Id, name);
        this.petType = petType;
        this.owner = owner;
        this.birthDate = birthDate;
    }

    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();

    @Override
    public String toString() {
        return "Pet{" +
                "id='" + this.getId() + '\'' +
                ", name='" + this.getName() + '\'' +
                ", petType=" + petType +
                ", owner=" + owner.getFirstName() + ", " + owner.getLastName() +
                ", birthDate=" + birthDate +
                '}';
    }
}
