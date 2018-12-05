package com.pierreveissi.sfpetclinic.services.map;

import com.pierreveissi.sfpetclinic.model.Owner;
import com.pierreveissi.sfpetclinic.services.CrudService;

import java.util.Set;

public class OwnerServiceMap
    extends AbstractMapService<Owner, Long>
    implements CrudService<Owner, Long>
{

  @Override
  public Set<Owner> findAll() {
    return super.findAll();
  }

  @Override
  public Owner findById(Long id) {
    return super.findById(id);
  }

  @Override
  public Owner save(Owner obj) {
    return super.save(obj.getId(), obj);
  }

  @Override
  public void delete(Owner obj) {
    super.delete(obj);
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }
}
