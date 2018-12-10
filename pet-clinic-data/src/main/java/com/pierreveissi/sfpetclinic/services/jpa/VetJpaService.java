package com.pierreveissi.sfpetclinic.services.jpa;

import com.pierreveissi.sfpetclinic.model.Vet;
import com.pierreveissi.sfpetclinic.repositories.VetRepo;
import com.pierreveissi.sfpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springjpa")
public class VetJpaService implements VetService {

  private final VetRepo vetRepo;

  public VetJpaService(VetRepo vetRepo) {
    this.vetRepo = vetRepo;
  }

  @Override
  public Set<Vet> findAll() {
    Set<Vet> vetSet = new HashSet<>();
    vetRepo.findAll().forEach(vetSet::add);
    return vetSet;
  }

  @Override
  public Vet findById(Long id) {
    Optional<Vet> optionalVet = vetRepo.findById(id);
    return optionalVet.orElse(null);
  }

  @Override
  public Vet save(Vet obj) {
    return vetRepo.save(obj);
  }

  @Override
  public void delete(Vet obj) {
    vetRepo.delete(obj);
  }

  @Override
  public void deleteById(Long id) {
    vetRepo.deleteById(id);
  }
}
