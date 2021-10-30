package com.springframework.spring5petclinic.services.springdatajpa;

import com.springframework.spring5petclinic.model.Visit;
import com.springframework.spring5petclinic.repositories.VisitRepository;
import com.springframework.spring5petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Profile("springdatajpa")
public class VisitSDJpaService implements VisitService {

    private final VisitRepository visitRepository;

    public VisitSDJpaService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        return StreamSupport.stream(visitRepository.findAll().spliterator(), false).collect(Collectors.toSet());
    }

    @Override
    public Optional<Visit> findById(Long aLong) {
        return visitRepository.findById(aLong);
    }

    @Override
    public Visit save(Visit visit) {
        return visitRepository.save(visit);
    }

    @Override
    public void delete(Visit visit) {
        visitRepository.delete(visit);
    }

    @Override
    public void deleteById(Long aLong) {
        visitRepository.deleteById(aLong);
    }
}
