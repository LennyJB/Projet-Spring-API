package efrei.projetspringapi.service;

import efrei.projetspringapi.entity.DogBreed;
import efrei.projetspringapi.entity.DogImage;
import efrei.projetspringapi.repository.DogBreedRepository;
import efrei.projetspringapi.repository.DogImageRepository;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DogService {

    private final DogBreedRepository dogBreedRepository;
    private final DogImageRepository dogImageRepository;
    private final RestClient restClient;

    public DogService(DogBreedRepository dogBreedRepository, DogImageRepository dogImageRepository) {
        this.dogBreedRepository = dogBreedRepository;
        this.dogImageRepository = dogImageRepository;
        this.restClient = RestClient.create();
    }

    public Map<String, Object> requestAllBreeds() {
        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("https")
                        .host("dog.ceo")
                        .path("/api/breeds/list/all")
                        .build())
                .retrieve()
                .body(new ParameterizedTypeReference<Map<String, Object>>() {});
    }

    public Map<String, String> requestRandomDog() {
        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("https")
                        .host("dog.ceo")
                        .path("/api/breeds/image/random")
                        .build())
                .retrieve()
                .body(new ParameterizedTypeReference<Map<String, String>>() {});
    }

    public DogImage fetchAndStoreRandomDogImage(String breed) {
        Map<String, String> response = restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("https")
                        .host("dog.ceo")
                        .path("/api/breed/" + breed + "/images/random")
                        .build())
                .retrieve()
                .body(new ParameterizedTypeReference<Map<String, String>>() {});

        if (response.containsKey("message")) {
            String imageUrl = response.get("message");

            DogBreed dogBreed = dogBreedRepository.findByBreed(breed)
                    .orElseGet(() -> {
                        DogBreed newBreed = new DogBreed(breed, List.of());
                        return dogBreedRepository.save(newBreed);
                    });

            DogImage dogImage = new DogImage(imageUrl, dogBreed);
            return dogImageRepository.save(dogImage);
        }
        throw new RuntimeException("Impossible de récupérer l'image pour la race : " + breed);
    }
}