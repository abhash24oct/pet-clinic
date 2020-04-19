package abhash.springframework.petclinic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name="pets")
public class Pet  extends BaseEntity{

    private String name;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private  PetType petType;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    private LocalDate birthDate;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();
}
