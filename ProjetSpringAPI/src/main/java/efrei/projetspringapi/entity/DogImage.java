package efrei.projetspringapi.entity;

import jakarta.persistence.*;

@Entity
public class DogImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "dog_breed_id", nullable = false)
    private DogBreed dogBreed;

    public DogImage() {}

    public DogImage(String imageUrl, DogBreed dogBreed) {
        this.imageUrl = imageUrl;
        this.dogBreed = dogBreed;
    }

    public Long getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public DogBreed getDogBreed() {
        return dogBreed;
    }

    public void setDogBreed(DogBreed dogBreed) {
        this.dogBreed = dogBreed;
    }
}
