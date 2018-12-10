package com.pierreveissi.sfpetclinic.services.jpa;

import com.pierreveissi.sfpetclinic.model.Specialty;
import com.pierreveissi.sfpetclinic.repositories.SpecialtyRepo;
import com.pierreveissi.sfpetclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springjpa")
public class SpecialtyJpaService implements SpecialtyService {
  private final SpecialtyRepo specialtyRepo;

  public SpecialtyJpaService(SpecialtyRepo specialtyRepo) {
    this.specialtyRepo = specialtyRepo;
  }

  @Override
  public Set<Specialty> findAll() {
    Set<Specialty> petSet = new HashSet<>();
    specialtyRepo.findAll().forEach(petSet::add);
    return petSet;
  }

  @Override
  public Specialty findById(Long id) {
    Optional<Specialty> optionalSpecialty = specialtyRepo.findById(id);
    return optionalSpecialty.orElse(null);
  }

  @Override
  public Specialty save(Specialty obj) {
    return specialtyRepo.save(obj);
  }

  @Override
  public void delete(Specialty obj) {
    specialtyRepo.delete(obj);
  }

  @Override
  public void deleteById(Long id) {
    specialtyRepo.deleteById(id);
  }
}
