package com.springframework.spring5petclinic.services;

import com.springframework.spring5petclinic.model.Owner;

public interface OwnerService<O extends Owner, L extends Long> extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
