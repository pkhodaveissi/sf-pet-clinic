package com.pierreveissi.sfpetclinic.services.jpa;

import com.pierreveissi.sfpetclinic.model.PetType;
import com.pierreveissi.sfpetclinic.repositories.PetTypeRepo;
import com.pierreveissi.sfpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("jpadata")
public class PetTypeJpaService implements PetTypeService {
  private final PetTypeRepo petTypeRepo;

  public PetTypeJpaService(PetTypeRepo petTypeRepo) {
    this.petTypeRepo = petTypeRepo;
  }

  @Override
  public Set<PetType> findAll() {
    Set<PetType> petTypeSet = new HashSet<>();
    petTypeRepo.findAll().forEach(petTypeSet::add);
    return petTypeSet;
  }

  @Override
  public PetType findById(Long id) {
    Optional<PetType> optionalPetType = petTypeRepo.findById(id);
    return optionalPetType.orElse(null);
  }

  @Override
  public PetType save(PetType obj) {
    return petTypeRepo.save(obj);
  }

  @Override
  public void delete(PetType obj) {
    petTypeRepo.delete(obj);
  }

  @Override
  public void deleteById(Long id) {
    petTypeRepo.deleteById(id);
  }
}
