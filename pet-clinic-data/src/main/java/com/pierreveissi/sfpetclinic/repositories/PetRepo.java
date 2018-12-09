package com.pierreveissi.sfpetclinic.repositories;

import com.pierreveissi.sfpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepo extends CrudRepository<Pet, Long> {
}
