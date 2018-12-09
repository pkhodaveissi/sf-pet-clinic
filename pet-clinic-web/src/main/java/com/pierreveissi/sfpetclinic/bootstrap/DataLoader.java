package com.pierreveissi.sfpetclinic.bootstrap;

import com.pierreveissi.sfpetclinic.model.Owner;
import com.pierreveissi.sfpetclinic.model.PetType;
import com.pierreveissi.sfpetclinic.model.Vet;
import com.pierreveissi.sfpetclinic.services.OwnerService;
import com.pierreveissi.sfpetclinic.services.PetTypeService;
import com.pierreveissi.sfpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
  private final OwnerService ownerService;
  private final VetService vetService;
  private final PetTypeService petTypeService;
  public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService){
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
    owner1.setFirstName("Pierre");
    owner1.setLastName("Veissi");

    ownerService.save(owner1);

    Owner owner2 = new Owner();
    owner2.setFirstName("Pafar");
    owner2.setLastName("Veissi");

    ownerService.save(owner2);

    System.out.println("Loaded Owners,,,");

    Vet vet1 = new Vet();
    vet1.setFirstName("Ed");
    vet1.setLastName("Max");

    vetService.save(vet1);

    Vet vet2 = new Vet();
    vet2.setFirstName("Seth");
    vet2.setLastName("Max");

    vetService.save(vet2);

    System.out.println("Loaded Vets,,,");
  }
}
