package abhash.springframework.petclinic.model;

import lombok.*;

import javax.persistence.MappedSuperclass;


@Getter
@Setter
@MappedSuperclass
public class Person  extends BaseEntity{

    private  String firstName;
    private String lastName;
}
