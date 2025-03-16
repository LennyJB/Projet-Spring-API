package efrei.projetspringapi.service;

import efrei.projetspringapi.entity.DogBreed;
import efrei.projetspringapi.repository.DogBreedRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogBreedService {

    private final DogBreedRepository dogBreedRepository;

    public DogBreedService(DogBreedRepository dogBreedRepository) {
        this.dogBreedRepository = dogBreedRepository;
    }

    public DogBreed createDogBreed(DogBreed dogBreed) {
        return dogBreedRepository.save(dogBreed);
    }

    public List<DogBreed> getAllDogBreeds() {
        return dogBreedRepository.findAll();
    }

    public Optional<DogBreed> getDogBreedById(Long id) {
        return dogBreedRepository.findById(id);
    }

    public DogBreed updateDogBreed(Long id, DogBreed updatedDogBreed) {
        return dogBreedRepository.findById(id)
                .map(existingBreed -> {
                    existingBreed.setBreed(updatedDogBreed.getBreed());
                    return dogBreedRepository.save(existingBreed);
                })
                .orElseThrow(() -> new RuntimeException("La race n'est pas trouvée avec l'id " + id));
    }

    public void deleteDogBreed(Long id) {
        dogBreedRepository.deleteById(id);
    }
}
