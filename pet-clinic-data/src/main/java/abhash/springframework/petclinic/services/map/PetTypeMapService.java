package abhash.springframework.petclinic.services.map;

import abhash.springframework.petclinic.model.PetType;
import abhash.springframework.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class PetTypeMapService extends AbstractMapService<PetType,Long> implements PetTypeService {
}
