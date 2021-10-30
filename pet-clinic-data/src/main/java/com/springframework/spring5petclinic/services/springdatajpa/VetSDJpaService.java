package com.springframework.spring5petclinic.services.springdatajpa;

import com.springframework.spring5petclinic.model.Vet;
import com.springframework.spring5petclinic.repositories.SpecialtyRepository;
import com.springframework.spring5petclinic.repositories.VetRepository;
import com.springframework.spring5petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {

    private final VetRepository vetRepository;
    private final SpecialtyRepository specialtyRepository;

    public VetSDJpaService(VetRepository vetRepository, SpecialtyRepository specialtyRepository) {
        this.vetRepository = vetRepository;
        this.specialtyRepository = specialtyRepository;
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

        vet.getSpecialties().forEach(specialty -> {
            if (specialty.getId() == null) {
                specialtyRepository.save(specialty);
            }
        });

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
