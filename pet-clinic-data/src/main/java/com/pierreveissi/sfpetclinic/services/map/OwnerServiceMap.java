package com.pierreveissi.sfpetclinic.services.map;

import com.pierreveissi.sfpetclinic.model.Owner;
import com.pierreveissi.sfpetclinic.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap
    extends AbstractMapService<Owner, Long>
    implements OwnerService
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
    return super.save(obj);
  }

  @Override
  public void delete(Owner obj) {
    super.delete(obj);
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }

  @Override
  public Owner findByLastName(String lastName) {
    return null;
  }
}
