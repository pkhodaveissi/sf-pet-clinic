package com.pierreveissi.sfpetclinic.repositories;

import com.pierreveissi.sfpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepo extends CrudRepository<Visit, Long> {
}
