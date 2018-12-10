package com.pierreveissi.sfpetclinic.services.map;

import com.pierreveissi.sfpetclinic.model.Owner;
import com.pierreveissi.sfpetclinic.model.Pet;
import com.pierreveissi.sfpetclinic.services.OwnerService;
import com.pierreveissi.sfpetclinic.services.PetService;
import com.pierreveissi.sfpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"mapdata", "default"})
public class OwnerMapService
    extends AbstractMapService<Owner, Long>
    implements OwnerService
{
  private final PetTypeService petTypeService;
  private final PetService petService;

  public OwnerMapService(PetTypeService petTypeService, PetService petService) {
    this.petTypeService = petTypeService;
    this.petService = petService;
  }

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

    if(obj != null){
      if (obj.getPets() != null) {
        obj.getPets().forEach(pet -> {
          if (pet.getPetType() != null){
            if(pet.getPetType().getId() == null){
              pet.setPetType(petTypeService.save(pet.getPetType()));
            }
          } else {
            throw new RuntimeException("Pet Type is required");
          }

          if(pet.getId() == null){
            Pet savedPet = petService.save(pet);
            pet.setId(savedPet.getId());
          }
        });
      }

      return super.save(obj);

    } else {
      return null;
    }
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
