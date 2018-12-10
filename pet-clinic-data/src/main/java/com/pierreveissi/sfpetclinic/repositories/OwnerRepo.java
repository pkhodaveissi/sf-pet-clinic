package com.pierreveissi.sfpetclinic.repositories;

import com.pierreveissi.sfpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepo extends CrudRepository<Owner, Long> {
  Owner findByLastName(String lastName);
}
