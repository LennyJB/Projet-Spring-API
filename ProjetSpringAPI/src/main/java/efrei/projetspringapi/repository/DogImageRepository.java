package efrei.projetspringapi.repository;

import efrei.projetspringapi.entity.DogImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogImageRepository extends JpaRepository<DogImage, Long> {
}