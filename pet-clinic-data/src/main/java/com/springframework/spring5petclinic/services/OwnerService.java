package com.springframework.spring5petclinic.services;

import com.springframework.spring5petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
