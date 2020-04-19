package abhash.springframework.petclinic.controllers;

import abhash.springframework.petclinic.model.Owner;
import abhash.springframework.petclinic.model.Vet;
import abhash.springframework.petclinic.services.VetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/vets")
@RequiredArgsConstructor
public class VetController {

    private final VetService vetService;


    @GetMapping
    public ResponseEntity<Set<Vet>> listVets(){
        return new ResponseEntity<Set<Vet>>(vetService.findAll(), HttpStatus.OK);
    }
}
