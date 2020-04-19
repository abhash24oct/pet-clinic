package abhash.springframework.petclinic.bootstrap;

import abhash.springframework.petclinic.model.*;
import abhash.springframework.petclinic.services.OwnerService;
import abhash.springframework.petclinic.services.PetTypeService;
import abhash.springframework.petclinic.services.SpecialityService;
import abhash.springframework.petclinic.services.VetService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private  final OwnerService ownerService;
    private  final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;



    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count==0)
            loadData();

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        final PetType dogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        final PetType catPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("Zuidwal 9");
        owner1.setCity("The Hague");
        owner1.setTelephone("0655932090");

        Pet mikesPet = new Pet();
        mikesPet.setName("Mosco");
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setPetType(dogPetType);
        mikesPet.setOwner(owner1);

        owner1.getPets().add(mikesPet);
        System.out.println(owner1);
        ownerService.save(owner1);

       Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("Zuidwal 9");
        owner2.setCity("The Hague");
        owner2.setTelephone("0655932090");

        Pet fionaPet = new Pet();
        fionaPet.setName("The cat ");
        fionaPet.setBirthDate(LocalDate.now());
        fionaPet.setPetType(catPetType);
        fionaPet.setOwner(owner2);

        owner2.getPets().add(fionaPet);


        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology=specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");

        Speciality savedDentistry=  specialityService.save(dentistry);

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(savedSurgery);
        vet2.getSpecialities().add(savedDentistry);

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}
