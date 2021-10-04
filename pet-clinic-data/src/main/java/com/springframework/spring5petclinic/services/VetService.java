package com.springframework.spring5petclinic.services;

import com.springframework.spring5petclinic.model.Vet;

public interface VetService extends CrudService<Vet, Long> {
    Vet findByLastName(String lastName);
}
