package com.springframework.spring5petclinic.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Builder
@Entity
@Table(name = "specialities")
public class Specialty extends NamedEntity {

}
