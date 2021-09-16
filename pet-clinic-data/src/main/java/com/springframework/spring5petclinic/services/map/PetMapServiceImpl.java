package com.springframework.spring5petclinic.services.map;

import com.springframework.spring5petclinic.model.Pet;
import com.springframework.spring5petclinic.services.CrudService;

public class PetMapServiceImpl extends AbstractMapService<Pet, Long> implements CrudService<Pet, Long> {

    @Override
    public Pet save(Pet pet) {
        return this.save(pet.getId(), pet);
    }
}
