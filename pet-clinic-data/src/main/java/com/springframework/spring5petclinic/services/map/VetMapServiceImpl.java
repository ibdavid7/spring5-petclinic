package com.springframework.spring5petclinic.services.map;

import com.springframework.spring5petclinic.model.Vet;
import com.springframework.spring5petclinic.services.CrudService;

import java.util.Locale;

public class VetMapServiceImpl extends AbstractMapService<Vet, Long> implements CrudService<Vet, Long> {
    @Override
    public Vet save(Vet vet) {
        return this.save(vet.getId(), vet);
    }

    public Vet findByLastName(String lastName) {
        return super.map.values()
                .stream()
                .filter(vet -> vet.getLastName().toLowerCase(Locale.ROOT).equals(lastName.toLowerCase(Locale.ROOT)))
                .findAny()
                .orElse(null);
    }
}
