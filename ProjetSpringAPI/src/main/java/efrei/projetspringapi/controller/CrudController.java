package efrei.projetspringapi.controller;

import efrei.projetspringapi.entity.DogBreed;
import efrei.projetspringapi.service.DogBreedService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/crud/dog-breeds")
public class CrudController {

    private final DogBreedService dogBreedService;

    public CrudController(DogBreedService dogBreedService) {
        this.dogBreedService = dogBreedService;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('CRUD')")
    public ResponseEntity<DogBreed> createDogBreed(@RequestBody DogBreed dogBreed) {
        DogBreed savedDogBreed = dogBreedService.createDogBreed(dogBreed);
        return ResponseEntity.ok(savedDogBreed);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('CRUD')")
    public ResponseEntity<List<DogBreed>> getAllDogBreeds() {
        return ResponseEntity.ok(dogBreedService.getAllDogBreeds());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('CRUD')")
    public ResponseEntity<DogBreed> getDogBreedById(@PathVariable Long id) {
        Optional<DogBreed> dogBreed = dogBreedService.getDogBreedById(id);
        return dogBreed.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('CRUD')")
    public ResponseEntity<DogBreed> updateDogBreed(@PathVariable Long id, @RequestBody DogBreed dogBreed) {
        DogBreed updatedDogBreed = dogBreedService.updateDogBreed(id, dogBreed);
        return ResponseEntity.ok(updatedDogBreed);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('CRUD')")
    public ResponseEntity<Void> deleteDogBreed(@PathVariable Long id) {
        dogBreedService.deleteDogBreed(id);
        return ResponseEntity.noContent().build();
    }
}

