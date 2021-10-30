package com.springframework.spring5petclinic.bootstrap;

import com.springframework.spring5petclinic.model.*;
import com.springframework.spring5petclinic.services.OwnerService;
import com.springframework.spring5petclinic.services.PetTypeService;
import com.springframework.spring5petclinic.services.VetService;
import com.springframework.spring5petclinic.services.VisitService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService<Owner, Long> ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final VisitService visitService;

    public DataInitializer(OwnerService<Owner, Long> ownerService, VetService vetService, PetTypeService petTypeService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        if (petTypeService.findAll().size() == 0) loadData();

    }

    private void loadData() {
        // Init PetType
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDog = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCat = petTypeService.save(cat);

        System.out.println("Loaded PetTypes....");

        // Init Owner
        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("111 Brick Lane");
        owner1.setCity("Miami");
        owner1.setTelephone("111-111-1111");

        // Init Pet
        Pet mikeDog1 = createPet(owner1, dog, "Rosco", LocalDate.of(2001, 1, 29));
        Pet mikeDog2 = createPet(owner1, dog, "Boss", LocalDate.of(2005, 12, 31));

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fionna");
        owner2.setLastName("Glenanne");
        owner2.setAddress("222 Marsh St");
        owner2.setCity("San Francisco");
        owner2.setTelephone("222-222-2222");

        // Init Pet
        Pet fionnaCat1 = createPet(owner2, cat, "Bumble", LocalDate.of(2008, 5, 1));
        Pet fionnaCat2 = createPet(owner2, cat, "Minnie", LocalDate.of(2019, 3, 3));

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        // Init Visit
        Visit visit1 = new Visit();
        visit1.setDescription("Sneezy kitty");
        visit1.setLocalDateTime(LocalDateTime.now());
        visit1.setPet(fionnaCat2);
        visitService.save(visit1);

        System.out.println("Loaded Visits...");

        // Init Specialty
        Specialty dentistry = new Specialty();
        dentistry.setName("Dentistry");

        Specialty surgery = new Specialty();
        surgery.setName("Surgery");

        Specialty radiology = new Specialty();
        radiology.setName("Radiology");

        // Init Vet
        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.addSpecialty(dentistry);
        vet1.addSpecialty(surgery);
        vet1.addSpecialty(radiology);

        vetService.save(vet1);


        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.addSpecialty(surgery);
        vet2.addSpecialty(radiology);
        vet2.addSpecialty(dentistry);
        vetService.save(vet2);

        System.out.println("Loaded Vets....");

        vetService.findAll().forEach(System.out::println);
    }

    private Pet createPet(Owner owner, PetType petType, String name, LocalDate dob) {

        Pet pet = new Pet();
        pet.setPetType(petType);
        pet.setName(name);
        pet.setBirthDate(dob);
        pet.setOwner(owner);
        owner.addPet(pet);
        return pet;
    }

}
