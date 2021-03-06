package com.pierreveissi.sfpetclinic.services.map;

import com.pierreveissi.sfpetclinic.model.Specialty;
import com.pierreveissi.sfpetclinic.model.Vet;
import com.pierreveissi.sfpetclinic.services.SpecialtyService;
import com.pierreveissi.sfpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
@Profile({"mapdata", "default"})
public class VetMapService
    extends AbstractMapService<Vet, Long>
    implements VetService
{
  private final SpecialtyService specialtyService;

  public VetMapService(SpecialtyService specialtyService) {
    this.specialtyService = specialtyService;
  }

  @Override
  public Set<Vet> findAll() {
    return super.findAll();
  }

  @Override
  public Vet findById(Long id) {
    return super.findById(id);
  }

  @Override
  public Vet save(Vet object) {

    if (object.getSpecialtySet().size() > 0){
      object.getSpecialtySet().forEach(speciality -> {
        if(speciality.getId() == null){
          Specialty savedSpecialty = specialtyService.save(speciality);
          speciality.setId(savedSpecialty.getId());
        }
      });
    }

    return super.save(object);
  }

  @Override
  public void delete(Vet obj) {
    super.delete(obj);
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }
}