package com.springframework.spring5petclinic.services.map;


import com.springframework.spring5petclinic.model.Owner;
import com.springframework.spring5petclinic.services.CrudService;

import java.util.Locale;
import java.util.Map;

public class OwnerMapServiceImpl extends AbstractMapService<Owner, Long>
        implements CrudService<Owner, Long> {

    @Override
    public Owner save(Owner owner) {
        return this.save(owner.getId(), owner);
    }

    public Owner findByLastName(String lastName) {

        return super.map.values()
                .stream()
                .filter(owner -> owner.getLastName().toLowerCase(Locale.ROOT).equals(lastName.toLowerCase(Locale.ROOT)))
                .findFirst()
                .orElse(null);
    }
}
