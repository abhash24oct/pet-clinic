package abhash.springframework.petclinic.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;


@Getter
@Setter
@Entity
@Table(name = "type")
public class PetType extends BaseEntity{
    private String name;
}
