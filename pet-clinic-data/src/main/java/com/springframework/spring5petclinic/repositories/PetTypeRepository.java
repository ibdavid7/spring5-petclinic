package com.springframework.spring5petclinic.repositories;

import com.springframework.spring5petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
