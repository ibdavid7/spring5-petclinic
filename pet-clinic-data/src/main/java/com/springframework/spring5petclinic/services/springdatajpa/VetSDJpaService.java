package com.springframework.spring5petclinic.services.springdatajpa;

import com.springframework.spring5petclinic.model.Vet;
import com.springframework.spring5petclinic.repositories.VetRepository;
import com.springframework.spring5petclinic.services.VetService;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class VetSDJpaService implements VetService {

    private final VetRepository vetRepository;

    public VetSDJpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        return StreamSupport.stream(vetRepository.findAll().spliterator(), false).collect(Collectors.toSet());
    }

    @Override
    public Optional<Vet> findById(Long aLong) {
        return vetRepository.findById(aLong);
    }

    @Override
    public Vet save(Vet vet) {
        return vetRepository.save(vet);
    }

    @Override
    public void delete(Vet vet) {
        vetRepository.delete(vet);
    }

    @Override
    public void deleteById(Long aLong) {
        vetRepository.deleteById(aLong);
    }

    @Override
    public Vet findByLastName(String lastName) {
        return vetRepository.findVetByLastName(lastName);
    }
}
