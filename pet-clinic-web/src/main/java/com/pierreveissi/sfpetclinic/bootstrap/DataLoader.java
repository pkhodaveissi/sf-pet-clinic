package com.pierreveissi.sfpetclinic.bootstrap;

import com.pierreveissi.sfpetclinic.model.Owner;
import com.pierreveissi.sfpetclinic.model.Vet;
import com.pierreveissi.sfpetclinic.services.OwnerService;
import com.pierreveissi.sfpetclinic.services.VetService;
import com.pierreveissi.sfpetclinic.services.map.OwnerServiceMap;
import com.pierreveissi.sfpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
  private final OwnerService ownerService;
  private final VetService vetService;

  public DataLoader(){
    ownerService = new OwnerServiceMap();
    vetService = new VetServiceMap();
  }
  @Override
  public void run(String... args) throws Exception {
    Owner owner1 = new Owner();
    owner1.setId(1L);
    owner1.setFirstName("Pierre");
    owner1.setLastName("Veissi");

    ownerService.save(owner1);

    Owner owner2 = new Owner();
    owner2.setId(2L);
    owner2.setFirstName("Pafar");
    owner2.setLastName("Veissi");

    ownerService.save(owner2);

    System.out.println("Loaded Owners,,,");

    Vet vet1 = new Vet();
    vet1.setId(1L);
    vet1.setFirstName("Ed");
    vet1.setLastName("Max");

    vetService.save(vet1);

    Vet vet2 = new Vet();
    vet2.setId(2L);
    vet2.setFirstName("Seth");
    vet2.setLastName("Max");

    vetService.save(vet2);

    System.out.println("Loaded Vets,,,");
  }
}
