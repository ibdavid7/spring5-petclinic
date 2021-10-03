package com.springframework.spring5petclinic.model;

public class Specialty extends NamedEntity {

    public String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
