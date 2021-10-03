package com.springframework.spring5petclinic.services;

import com.springframework.spring5petclinic.model.PetType;

public interface PetTypeService<P extends PetType, L extends Long> extends CrudService<PetType, Long>{
}
