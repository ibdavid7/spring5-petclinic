package com.springframework.spring5petclinic.services;

import com.springframework.spring5petclinic.model.Vet;

import java.util.Set;

public interface VetService extends CrudService<Vet, Long> {
    Vet findByLastName(String lastName);
}