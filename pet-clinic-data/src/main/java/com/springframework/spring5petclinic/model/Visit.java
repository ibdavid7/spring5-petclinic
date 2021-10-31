package com.springframework.spring5petclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {

    @Column(name = "visit_date")
    private LocalDateTime localDateTime;

    @Column(name = "description")
    private String description;

    @ManyToOne()
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public Visit() {
        this.localDateTime = LocalDateTime.now();
    }

}
