package com.springframework.spring5petclinic.services.map;

import com.springframework.spring5petclinic.model.Vet;
import com.springframework.spring5petclinic.services.SpecialityService;
import com.springframework.spring5petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@Profile({"default", "map"})
public class VetMapServiceImpl extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityService specialityService;

    public VetMapServiceImpl(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Vet save(Vet vet) {

        if (vet == null) {
            return null;
        }

        vet.getSpecialties()
                .forEach(specialty -> {
                    // If Speciality not yet persisted, add Speciality to SpecialityService
                    if (specialty.getId() == null) {
                        specialityService.save(specialty);
                    }
                });

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
