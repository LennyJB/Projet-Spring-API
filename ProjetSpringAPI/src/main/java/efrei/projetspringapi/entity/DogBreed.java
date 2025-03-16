package efrei.projetspringapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
public class DogBreed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotBlank
    private String breed;

    @OneToMany(mappedBy = "dogBreed", cascade = CascadeType.ALL)
    private List<DogImage> images;

    public DogBreed() {}

    public DogBreed(String breed, List<String> subBreeds) {
        this.breed = breed;
    }

    public Long getId() {
        return id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public List<DogImage> getImages() {
        return images;
    }

    public void setImages(List<DogImage> images) {
        this.images = images;
    }
}
