package com.example.springframework.bootstrap;

import com.example.springframework.model.*;
import com.example.springframework.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialtyService specialtyService, VisitService visitService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0){
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialtyService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialtyService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialtyService.save(dentistry);

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

        Visit catVisit = new Visit();
        catVisit.setPet(rita);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");

        visitService.save(catVisit);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Antonio");
        vet1.setLastName("Martinez");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Pepe");
        vet2.setLastName("Paez");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
