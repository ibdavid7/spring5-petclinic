package com.springframework.spring5petclinic.services.map;


import com.springframework.spring5petclinic.model.Owner;
import com.springframework.spring5petclinic.model.Pet;
import com.springframework.spring5petclinic.services.OwnerService;
import com.springframework.spring5petclinic.services.PetService;
import com.springframework.spring5petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class OwnerMapServiceImpl extends AbstractMapService<Owner, Long>
        implements OwnerService<Owner, Long> {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapServiceImpl(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner save(Owner owner) {

        if (owner == null) {
            return null;
        }

        owner.getPets().stream()
                .forEach(pet -> {
                    // Pet requires PetType, mandatory field
                    if (pet.getPetType() == null) {
                        throw new IllegalArgumentException("Pet missing PetType, Pet requires PetType");
                    }

                    // If PetType not yet persisted, add PetType to PetTypeService
                    if (pet.getPetType().getId() == null) {
                        pet.setPetType(petTypeService.save(pet.getPetType()));
                    }

                    // If Pet not yet persisted, add Pet to PetService
                    if (pet.getId() == null) {
                        petService.save(pet);
                    }
                });

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
