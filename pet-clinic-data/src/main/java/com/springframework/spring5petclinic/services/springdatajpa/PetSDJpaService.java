package com.springframework.spring5petclinic.services.springdatajpa;

import com.springframework.spring5petclinic.model.Pet;
import com.springframework.spring5petclinic.repositories.PetRepository;
import com.springframework.spring5petclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Profile("springdatajpa")
public class PetSDJpaService implements PetService {

    private final PetRepository petRepository;

    public PetSDJpaService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        return StreamSupport.stream(petRepository.findAll().spliterator(), false).collect(Collectors.toSet());
    }

    @Override
    public Optional<Pet> findById(Long aLong) {
        return petRepository.findById(aLong);
    }

    @Override
    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public void delete(Pet pet) {
        petRepository.delete(pet);
    }

    @Override
    public void deleteById(Long aLong) {
        petRepository.deleteById(aLong);
    }
}
