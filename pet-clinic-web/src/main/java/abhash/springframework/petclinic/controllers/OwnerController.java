package abhash.springframework.petclinic.controllers;

import abhash.springframework.petclinic.model.Owner;
import abhash.springframework.petclinic.services.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/owners")
@RequiredArgsConstructor
public class OwnerController {

    private  final OwnerService ownerService ;

    @RequestMapping("")
    public String listOwner(){
        return null;
    }

    @GetMapping
    public ResponseEntity<Set<Owner>> listOwners(){
        return new ResponseEntity<Set<Owner>>(ownerService.findAll(), HttpStatus.OK);
    }
}
