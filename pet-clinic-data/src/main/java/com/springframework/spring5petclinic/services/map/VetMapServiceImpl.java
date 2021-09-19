package com.springframework.spring5petclinic.services.map;

import com.springframework.spring5petclinic.model.Vet;
import com.springframework.spring5petclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class VetMapServiceImpl extends AbstractMapService<Vet, Long> implements VetService<Vet, Long> {
    @Override
    public Vet save(Vet vet) {
        return super.save(vet);
    }

    public Vet findByLastName(String lastName) {
        return super.map.values()
                .stream()
                .filter(vet -> vet.getLastName().toLowerCase(Locale.ROOT).equals(lastName.toLowerCase(Locale.ROOT)))
                .findAny()
                .orElse(null);
    }
}
