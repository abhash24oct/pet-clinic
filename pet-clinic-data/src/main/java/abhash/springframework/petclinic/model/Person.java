package abhash.springframework.petclinic.model;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private  String firstName;
    private String lastName;
}
