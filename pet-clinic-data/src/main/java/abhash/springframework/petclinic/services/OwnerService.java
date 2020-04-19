package abhash.springframework.petclinic.services;

import abhash.springframework.petclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner,Long>{

    Owner findByLastName(String lastName);

}
