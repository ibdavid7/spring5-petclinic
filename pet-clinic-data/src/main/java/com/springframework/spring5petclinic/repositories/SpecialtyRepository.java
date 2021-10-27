package com.springframework.spring5petclinic.repositories;

import com.springframework.spring5petclinic.model.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
