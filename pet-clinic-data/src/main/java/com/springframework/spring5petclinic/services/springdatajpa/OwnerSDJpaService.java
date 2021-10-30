package com.springframework.spring5petclinic.services.springdatajpa;

import com.springframework.spring5petclinic.model.Owner;
import com.springframework.spring5petclinic.repositories.OwnerRepository;
import com.springframework.spring5petclinic.services.OwnerService;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.Priority;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService<Owner, Long> {

    private final OwnerRepository ownerRepository;

    public OwnerSDJpaService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Set<Owner> findAll() {
        return StreamSupport.stream(ownerRepository.findAll().spliterator(), false).collect(Collectors.toSet());
    }

    @Override
    public Optional<Owner> findById(Long aLong) {
        return ownerRepository.findById(aLong);
    }

    @Override
    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public void delete(Owner owner) {
        ownerRepository.delete(owner);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findOwnerByLastName(lastName);
    }
}
