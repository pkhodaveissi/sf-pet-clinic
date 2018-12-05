package com.pierreveissi.sfpetclinic.services.map;

import com.pierreveissi.sfpetclinic.model.Pet;
import com.pierreveissi.sfpetclinic.services.CrudService;

import java.util.Set;

public class PetServiceMap
    extends AbstractMapService<Pet, Long>
    implements CrudService<Pet, Long>
{

  @Override
  public Set<Pet> findAll() {
    return super.findAll();
  }

  @Override
  public Pet findById(Long id) {
    return super.findById(id);
  }

  @Override
  public Pet save(Pet obj) {
    return super.save(obj.getId(), obj);
  }

  @Override
  public void delete(Pet obj) {
    super.delete(obj);
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }
}