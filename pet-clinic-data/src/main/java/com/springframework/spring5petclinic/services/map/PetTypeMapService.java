package com.springframework.spring5petclinic.services.map;

import com.springframework.spring5petclinic.model.PetType;
import com.springframework.spring5petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long>
        implements PetTypeService/*<PetType, Long>*/ {

/*    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }*/
}
