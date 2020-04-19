package abhash.springframework.petclinic.services.map;

import abhash.springframework.petclinic.model.Speciality;
import abhash.springframework.petclinic.services.SpecialityService;
import org.springframework.stereotype.Service;

@Service
public class SpecialityMapService extends AbstractMapService<Speciality,Long> implements SpecialityService {
}
