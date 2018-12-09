package com.pierreveissi.sfpetclinic.repositories;

import com.pierreveissi.sfpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepo extends CrudRepository<PetType, Long> {
}
