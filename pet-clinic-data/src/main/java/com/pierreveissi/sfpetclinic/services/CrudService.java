package com.pierreveissi.sfpetclinic.services;

import java.util.Set;

public interface CrudService<Type, ID> {
  Set<Type>findAll();
  Type findById(ID id);
  Type save(Type obj);
  void delete(Type obj);
  void deleteById(ID id);
}
