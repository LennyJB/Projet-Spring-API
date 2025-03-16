package efrei.projetspringapi.repository;

import efrei.projetspringapi.entity.DogBreed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DogBreedRepository extends JpaRepository<DogBreed, Long> {
    Optional<DogBreed> findByBreed(String breed);
}
