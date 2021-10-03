package com.springframework.spring5petclinic.bootstrap;

import com.springframework.spring5petclinic.model.Owner;
import com.springframework.spring5petclinic.model.Pet;
import com.springframework.spring5petclinic.model.PetType;
import com.springframework.spring5petclinic.model.Vet;
import com.springframework.spring5petclinic.services.OwnerService;
import com.springframework.spring5petclinic.services.PetTypeService;
import com.springframework.spring5petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService<Owner, Long> ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataInitializer(OwnerService<Owner, Long> ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

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

        // Init Vet
        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vetService.save(vet2);

        System.out.println("Loaded Vets....");

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
