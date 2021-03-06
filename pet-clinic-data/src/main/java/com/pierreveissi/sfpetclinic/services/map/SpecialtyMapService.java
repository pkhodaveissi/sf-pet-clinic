package com.pierreveissi.sfpetclinic.services.map;

import com.pierreveissi.sfpetclinic.model.Specialty;
import com.pierreveissi.sfpetclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"mapdata", "default"})
public class SpecialtyMapService
    extends AbstractMapService<Specialty, Long>
    implements SpecialtyService {
  @Override
  public Set<Specialty> findAll() {
    return super.findAll();
  }

  @Override
  public Specialty findById(Long id) {
    return super.findById(id);
  }

  @Override
  public Specialty save(Specialty obj) {
    return super.save(obj);
  }

  @Override
  public void delete(Specialty obj) {
    super.delete(obj);
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }
}
