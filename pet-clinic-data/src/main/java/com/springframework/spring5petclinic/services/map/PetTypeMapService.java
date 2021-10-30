package com.springframework.spring5petclinic.services.map;

import com.springframework.spring5petclinic.model.PetType;
import com.springframework.spring5petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class PetTypeMapService extends AbstractMapService<PetType, Long>
        implements PetTypeService/*<PetType, Long>*/ {

/*    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }*/
}
