package abhash.springframework.petclinic.services.map;

import abhash.springframework.petclinic.model.Pet;
import abhash.springframework.petclinic.services.PetService;
import org.springframework.stereotype.Service;

@Service
public class PetServiceMap extends AbstractMapService<Pet,Long>  implements PetService {

}
