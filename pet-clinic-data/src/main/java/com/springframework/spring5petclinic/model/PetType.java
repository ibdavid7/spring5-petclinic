package com.springframework.spring5petclinic.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Builder
@Entity
@Table(name = "types")
public class PetType extends NamedEntity {

}
