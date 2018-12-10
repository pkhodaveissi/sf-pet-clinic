package com.pierreveissi.sfpetclinic.services.jpa;

import com.pierreveissi.sfpetclinic.model.Visit;
import com.pierreveissi.sfpetclinic.repositories.VisitRepo;
import com.pierreveissi.sfpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("jpadata")
public class VisitJpaService implements VisitService {
  private final VisitRepo visitRepo;

  public VisitJpaService(VisitRepo visitRepo) {
    this.visitRepo = visitRepo;
  }

  @Override
  public Set<Visit> findAll() {
    Set<Visit> visitSet = new HashSet<>();
    visitRepo.findAll().forEach(visitSet::add);
    return visitSet;
  }

  @Override
  public Visit findById(Long id) {
    Optional<Visit> optionalVisit = visitRepo.findById(id);
    return optionalVisit.orElse(null);
  }

  @Override
  public Visit save(Visit obj) {
    return visitRepo.save(obj);
  }

  @Override
  public void delete(Visit obj) {
    visitRepo.delete(obj);
  }

  @Override
  public void deleteById(Long id) {
    visitRepo.deleteById(id);
  }
}
