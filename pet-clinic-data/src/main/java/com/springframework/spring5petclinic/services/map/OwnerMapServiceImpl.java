package com.springframework.spring5petclinic.services.map;


import com.springframework.spring5petclinic.model.Owner;
import com.springframework.spring5petclinic.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class OwnerMapServiceImpl extends AbstractMapService<Owner, Long>
        implements OwnerService<Owner, Long> {

    @Override
    public Owner save(Owner owner) {
        return super.save(owner);
    }

    public Owner findByLastName(String lastName) {

        return super.map.values()
                .stream()
                .filter(owner -> owner.getLastName().toLowerCase(Locale.ROOT).equals(lastName.toLowerCase(Locale.ROOT)))
                .findFirst()
                .orElse(null);
    }
}
