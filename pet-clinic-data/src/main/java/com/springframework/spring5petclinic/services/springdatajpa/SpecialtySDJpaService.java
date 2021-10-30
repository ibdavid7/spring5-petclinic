package com.springframework.spring5petclinic.services.springdatajpa;

import com.springframework.spring5petclinic.model.Specialty;
import com.springframework.spring5petclinic.repositories.SpecialtyRepository;
import com.springframework.spring5petclinic.services.SpecialityService;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class SpecialtySDJpaService implements SpecialityService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialtySDJpaService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Specialty> findAll() {
        return StreamSupport.stream(specialtyRepository.findAll().spliterator(), false).collect(Collectors.toSet());
    }

    @Override
    public Optional<Specialty> findById(Long aLong) {
        return specialtyRepository.findById(aLong);
    }

    @Override
    public Specialty save(Specialty specialty) {
        return specialtyRepository.save(specialty);
    }

    @Override
    public void delete(Specialty specialty) {
        specialtyRepository.delete(specialty);
    }

    @Override
    public void deleteById(Long aLong) {
        specialtyRepository.deleteById(aLong);
    }
}
