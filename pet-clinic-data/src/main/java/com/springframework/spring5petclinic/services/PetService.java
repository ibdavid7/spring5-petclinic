package com.springframework.spring5petclinic.services;

import com.springframework.spring5petclinic.model.Pet;

import java.util.Set;

public interface PetService/*<P extends Pet, L extends Long>*/ extends CrudService<Pet, Long> {

}
