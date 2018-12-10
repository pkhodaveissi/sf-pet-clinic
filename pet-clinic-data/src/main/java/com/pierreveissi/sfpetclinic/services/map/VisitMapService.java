package com.pierreveissi.sfpetclinic.services.map;

import com.pierreveissi.sfpetclinic.model.Visit;
import com.pierreveissi.sfpetclinic.services.VisitService;

import java.util.Set;

public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {
  @Override
  public Set<Visit> findAll() {
    return super.findAll();
  }

  @Override
  public Visit findById(Long id) {
    return super.findById(id);
  }

  @Override
  public Visit save(Visit obj) {
    if(obj.getPet() == null ||
        obj.getPet().getOwner() == null ||
        obj.getPet().getId() == null ||
        obj.getPet().getOwner().getId() == null
    ){
       throw new RuntimeException("Invalid Visit");
    }
    return super.save(obj);
  }

  @Override
  public void delete(Visit obj) {
    super.delete(obj);
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }
}
