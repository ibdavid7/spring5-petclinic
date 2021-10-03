package com.springframework.spring5petclinic.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Visit extends BaseEntity{

    private LocalDateTime localDateTime;
    private String description;
    private Pet pet;

    public Visit() {
        this.localDateTime = LocalDateTime.now();
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
