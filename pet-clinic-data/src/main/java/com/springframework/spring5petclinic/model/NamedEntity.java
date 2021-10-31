package com.springframework.spring5petclinic.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@ToString
@MappedSuperclass
public class NamedEntity extends BaseEntity {

    public NamedEntity() {
    }

    public NamedEntity(Long Id, String name) {
        super(Id);
        this.name = name;
    }

    @Column(name = "name")
    private String name;

/*    @Override
    public String toString() {
        return "NamedEntity{" +
                "id='" + this.getId() + '\'' +
                ", name='" + name + '\'' +
                '}';
    }*/
}
