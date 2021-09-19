package com.springframework.spring5petclinic.bootstrap;

import com.springframework.spring5petclinic.model.Owner;
import com.springframework.spring5petclinic.model.Person;
import com.springframework.spring5petclinic.model.Vet;
import com.springframework.spring5petclinic.services.OwnerService;
import com.springframework.spring5petclinic.services.VetService;
import org.aspectj.weaver.loadtime.Options;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService<Owner, Long> ownerService;
    private final VetService vetService;

    public DataInitializer(OwnerService<Owner, Long> ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Fionna");
        owner2.setLastName("Glenanne");
        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}
