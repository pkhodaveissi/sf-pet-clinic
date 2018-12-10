package com.pierreveissi.sfpetclinic.services.jpa;

import com.pierreveissi.sfpetclinic.model.Owner;
import com.pierreveissi.sfpetclinic.repositories.OwnerRepo;
import com.pierreveissi.sfpetclinic.repositories.PetRepo;
import com.pierreveissi.sfpetclinic.repositories.PetTypeRepo;
import com.pierreveissi.sfpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springjpa")
public class OwnerJpaService implements OwnerService {

  private final OwnerRepo ownerRepo;
  private final PetRepo petRepo;
  private final PetTypeRepo petTypeRepo;

  public OwnerJpaService(OwnerRepo ownerRepo, PetRepo petRepo, PetTypeRepo petTypeRepo) {
    this.ownerRepo = ownerRepo;
    this.petRepo = petRepo;
    this.petTypeRepo = petTypeRepo;
  }

  @Override
  public Owner findByLastName(String lastName) {
    return ownerRepo.findByLastName(lastName);
  }

  @Override
  public Set<Owner> findAll() {
    Set<Owner> ownerSet = new HashSet<>();
    ownerRepo.findAll().forEach(ownerSet::add);
    return ownerSet;
  }

  @Override
  public Owner findById(Long id) {
    Optional<Owner>  optionalOwner = ownerRepo.findById(id);
    return optionalOwner.orElse(null);
  }

  @Override
  public Owner save(Owner obj) {
    return ownerRepo.save(obj);
  }

  @Override
  public void delete(Owner obj) {
    ownerRepo.delete(obj);
  }

  @Override
  public void deleteById(Long id) {
    ownerRepo.deleteById(id);
  }
}
