package com.pierreveissi.sfpetclinic.services.map;

import com.pierreveissi.sfpetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<Type extends BaseEntity, ID extends Long> {
  protected Map<Long, Type> map = new HashMap<>();

  Set<Type> findAll() {
    return new HashSet<>(map.values());
  }

  Type findById(ID id) {
    return map.get(id);
  }

  Type save(Type obj) {
    if (obj != null) {
      if (obj.getId() == null) {
        obj.setId(getNextId());
      }
      map.put(obj.getId(), obj);
    } else {
      throw new RuntimeException("Entity Obj cannot be null");
    }
    return obj;
  }

  void deleteById(ID id) {
    map.remove(id);
  }

  void delete(Type obj) {
    map.entrySet()
        .removeIf(entry -> entry.getValue().equals(obj));
  }

  private Long getNextId() {
    Long currentMapLength;
    try {
      currentMapLength = Collections.max(map.keySet());
    }catch (NoSuchElementException e){
      currentMapLength = 0L;
    }
    return  currentMapLength + 1;
  }
}
