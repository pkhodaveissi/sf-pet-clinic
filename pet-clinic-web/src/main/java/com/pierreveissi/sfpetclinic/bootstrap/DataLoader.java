package com.pierreveissi.sfpetclinic.bootstrap;

import com.pierreveissi.sfpetclinic.model.*;
import com.pierreveissi.sfpetclinic.services.OwnerService;
import com.pierreveissi.sfpetclinic.services.PetTypeService;
import com.pierreveissi.sfpetclinic.services.SpecialtyService;
import com.pierreveissi.sfpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
  private final OwnerService ownerService;
  private final VetService vetService;
  private final PetTypeService petTypeService;
  private final SpecialtyService specialtyService;
  public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService){
    this.ownerService = ownerService;
    this.vetService = vetService;
    this.petTypeService = petTypeService;
    this.specialtyService = specialtyService;
  }

  @Override
  public void run(String... args) throws Exception {
    int count = petTypeService.findAll().size();

    if (count == 0 ) {
      populateData();
    }
  }

  private void populateData() {
    PetType dog = new PetType();
    dog.setName("Dog");
    PetType savedDogPetType = petTypeService.save(dog);

    PetType cat = new PetType();
    cat.setName("Cat");
    PetType savedCatPetType = petTypeService.save(cat);

    Specialty radiology = new Specialty();
    radiology.setDescription("Radiology");
    Specialty savedRadiology = specialtyService.save(radiology);

    Specialty surgery = new Specialty();
    surgery.setDescription("Surgery");
    Specialty savedSurgery = specialtyService.save(surgery);

    Specialty dentistry = new Specialty();
    dentistry.setDescription("dentistry");
    Specialty savedDentistry = specialtyService.save(dentistry);


    Owner owner1 = new Owner();
    owner1.setFirstName("Pierre");
    owner1.setLastName("Veissi");
    owner1.setAddress("123 Boston St.");
    owner1.setCity("Miami");
    owner1.setTelephone("555-654-6565");
    Pet pierresPet = new Pet();
    pierresPet.setPetType(savedDogPetType);
    pierresPet.setBirthDate(LocalDate.now());
    pierresPet.setName("Max");
    owner1.getPets().add(pierresPet);
    ownerService.save(owner1);

    Owner owner2 = new Owner();
    owner2.setFirstName("Pafar");
    owner2.setLastName("Veissi");
    owner2.setAddress("321 Jackson St.");
    owner2.setCity("Boston");
    owner2.setTelephone("444-654-6565");
    Pet pafarsPet = new Pet();
    pafarsPet.setPetType(savedCatPetType);
    pafarsPet.setBirthDate(LocalDate.now());
    pafarsPet.setName("Pishy");
    owner2.getPets().add(pafarsPet);
    ownerService.save(owner2);

    System.out.println("Loaded Owners,,,");

    Vet vet1 = new Vet();
    vet1.setFirstName("Ed");
    vet1.setLastName("Max");
    vet1.getSpecialtySet().add(savedRadiology);
    vetService.save(vet1);

    Vet vet2 = new Vet();
    vet2.setFirstName("Seth");
    vet2.setLastName("Max");
    vet2.getSpecialtySet().add(savedSurgery);
    vetService.save(vet2);

    System.out.println("Loaded Vets,,,");
  }
}
