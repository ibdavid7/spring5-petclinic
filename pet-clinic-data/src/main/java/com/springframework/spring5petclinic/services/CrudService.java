package com.springframework.spring5petclinic.services;

import java.util.Optional;
import java.util.Set;

public interface CrudService<T, ID> {

    Set<T> findAll();

    Optional<T> findById(ID id);

    T save(T t);

    void delete(T t);

    void deleteById(ID id);

}
