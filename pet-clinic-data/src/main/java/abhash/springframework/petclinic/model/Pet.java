package abhash.springframework.petclinic.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {

    private  PetType petType;
    private Owner owner;
    private LocalDate birthDate;

}
