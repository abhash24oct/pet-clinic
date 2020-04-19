package abhash.springframework.petclinic.services.map;

import abhash.springframework.petclinic.model.Owner;
import abhash.springframework.petclinic.model.Pet;
import abhash.springframework.petclinic.services.OwnerService;
import abhash.springframework.petclinic.services.PetService;
import abhash.springframework.petclinic.services.PetTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    @Override
    public Owner findByLastName(String lastName) {
        return (Owner) super.map.entrySet()
                .stream().filter(s -> s.getValue().getLastName().equals(lastName));
    }


    public  Owner save(Owner object){

        if(object!=null){
            if(object.getPets()!=null){
                object.getPets().forEach( pet ->{
                    if(pet.getPetType()!=null) {
                        if (pet.getPetType().getId() == null) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    }else
                        throw new RuntimeException("Pet type is required");

                    if(pet.getId() ==null){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }


                });
            }

            return super.save(object);
        }

        return null;
    }
}
