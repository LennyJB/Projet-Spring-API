package efrei.projetspringapi.controller;

import efrei.projetspringapi.entity.DogImage;
import efrei.projetspringapi.service.DogService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/scraper")
public class ScraperController {

    private final DogService dogService;

    public ScraperController(DogService dogService) {
        this.dogService = dogService;
    }

    @PostMapping("/fetch/{breed}")
    @PreAuthorize("hasAuthority('SCRAPER')")
    public ResponseEntity<DogImage> fetchAndStoreRandomDogImage(@PathVariable String breed) {
        return ResponseEntity.ok(dogService.fetchAndStoreRandomDogImage(breed));
    }
}
