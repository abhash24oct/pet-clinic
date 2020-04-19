package abhash.springframework.petclinic.services.map;

import abhash.springframework.petclinic.model.Vet;
import abhash.springframework.petclinic.services.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetServiceMap extends AbstractMapService<Vet,Long> implements VetService {

}
