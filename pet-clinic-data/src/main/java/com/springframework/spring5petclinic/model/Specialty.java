package com.springframework.spring5petclinic.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "specialities")
public class Specialty extends NamedEntity {

}
