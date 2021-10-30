package com.springframework.spring5petclinic.services.map;

import com.springframework.spring5petclinic.model.Pet;
import com.springframework.spring5petclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class PetMapServiceImpl extends AbstractMapService<Pet, Long>
        implements PetService/*<Pet, Long>*/ {

/*    @Override
    public Pet save(Pet pet) {
        return (Pet) super.save(pet);
    }*/
}
