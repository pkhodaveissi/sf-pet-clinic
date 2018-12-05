package com.pierreveissi.sfpetclinic.services;

import com.pierreveissi.sfpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {
  Owner findByLastName(String lastName);

}
