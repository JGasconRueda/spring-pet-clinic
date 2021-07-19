package com.example.springframework.bootstrap;

import com.example.springframework.model.Owner;
import com.example.springframework.model.PetType;
import com.example.springframework.model.Vet;
import com.example.springframework.services.OwnerService;
import com.example.springframework.services.PetTypeService;
import com.example.springframework.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");

        petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");

        petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Miguel");
        owner1.setLastName("Perez");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Juan");
        owner2.setLastName("SinMiedo");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Antonio");
        vet1.setLastName("Martinez");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Pepe");
        vet2.setLastName("Paez");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
