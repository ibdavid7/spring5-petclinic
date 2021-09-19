package com.springframework.spring5petclinic.services;

import com.springframework.spring5petclinic.model.Vet;

import java.util.Set;

public interface VetService<V extends Vet, L extends Long> extends CrudService<Vet, Long> {
    Vet findByLastName(String lastName);
}
