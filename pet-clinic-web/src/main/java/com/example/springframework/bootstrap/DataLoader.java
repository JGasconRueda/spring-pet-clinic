package com.example.springframework.bootstrap;

import com.example.springframework.model.Owner;
import com.example.springframework.model.Pet;
import com.example.springframework.model.PetType;
import com.example.springframework.model.Vet;
import com.example.springframework.services.OwnerService;
import com.example.springframework.services.PetTypeService;
import com.example.springframework.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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

        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");

        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Miguel");
        owner1.setLastName("Perez");
        owner1.setAddress("Calle Cardanas 2");
        owner1.setCity("Merida");
        owner1.setTelephone("666999888");

        Pet golfo = new Pet();
        golfo.setPetType(savedDogPetType);
        golfo.setOwner(owner1);
        golfo.setBirthDate(LocalDate.now());
        golfo.setName("Golfo");
        owner1.getPets().add(golfo);

        ownerService.save(owner1);


        Owner owner2 = new Owner();
        owner2.setFirstName("Juan");
        owner2.setLastName("SinMiedo");
        owner2.setAddress("Residencial Aldebaran 9");
        owner2.setCity("Dos hermanas");
        owner2.setTelephone("955663446");

        Pet rita = new Pet();
        rita.setPetType(savedCatPetType);
        rita.setOwner(owner2);
        rita.setBirthDate(LocalDate.now());
        rita.setName("Rita");
        owner2.getPets().add(rita);

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
