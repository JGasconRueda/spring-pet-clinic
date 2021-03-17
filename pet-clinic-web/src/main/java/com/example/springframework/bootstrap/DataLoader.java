package com.example.springframework.bootstrap;

import com.example.springframework.model.Owner;
import com.example.springframework.model.Vet;
import com.example.springframework.services.OwnerService;
import com.example.springframework.services.VetService;
import com.example.springframework.services.map.OwnerServiceMap;
import com.example.springframework.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Miguel");
        owner1.setLastName("Perez");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Juan");
        owner2.setLastName("SinMiedo");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Antonio");
        vet1.setLastName("Martinez");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Pepe");
        vet2.setLastName("Paez");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
