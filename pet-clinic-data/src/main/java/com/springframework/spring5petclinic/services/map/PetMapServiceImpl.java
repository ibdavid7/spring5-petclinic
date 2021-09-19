package com.springframework.spring5petclinic.services.map;

import com.springframework.spring5petclinic.model.Pet;
import com.springframework.spring5petclinic.services.CrudService;
import com.springframework.spring5petclinic.services.PetService;
import org.springframework.stereotype.Service;

@Service
public class PetMapServiceImpl extends AbstractMapService<Pet, Long> implements PetService<Pet, Long> {

    @Override
    public Pet save(Pet pet) {
        return super.save(pet);
    }
}
