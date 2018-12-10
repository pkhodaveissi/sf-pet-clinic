package com.pierreveissi.sfpetclinic.services.jpa;

import com.pierreveissi.sfpetclinic.model.Pet;
import com.pierreveissi.sfpetclinic.repositories.PetRepo;
import com.pierreveissi.sfpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springjpa")
public class PetJpaService implements PetService {
  private final PetRepo petRepo;

  public PetJpaService(PetRepo petRepo) {
    this.petRepo = petRepo;
  }

  @Override
  public Set<Pet> findAll() {
    Set<Pet> petSet = new HashSet<>();
    petRepo.findAll().forEach(petSet::add);
    return petSet;
  }

  @Override
  public Pet findById(Long id) {
    Optional<Pet> optionalPet = petRepo.findById(id);
    return optionalPet.orElse(null);
  }

  @Override
  public Pet save(Pet obj) {
    return petRepo.save(obj);
  }

  @Override
  public void delete(Pet obj) {
    petRepo.delete(obj);
  }

  @Override
  public void deleteById(Long id) {
    petRepo.deleteById(id);
  }
}
