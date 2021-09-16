package com.springframework.spring5petclinic.model;

import java.io.Serializable;

public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long Id;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
}
