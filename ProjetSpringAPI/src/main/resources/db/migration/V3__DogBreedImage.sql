CREATE TABLE dog_breed
(
    id    BIGINT AUTO_INCREMENT NOT NULL,
    breed VARCHAR(255) NULL,
    CONSTRAINT pk_dogbreed PRIMARY KEY (id)
);

CREATE TABLE dog_image
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    image_url    VARCHAR(255) NULL,
    dog_breed_id BIGINT NOT NULL,
    CONSTRAINT pk_dogimage PRIMARY KEY (id)
);

ALTER TABLE dog_image
    ADD CONSTRAINT FK_DOGIMAGE_ON_DOG_BREED FOREIGN KEY (dog_breed_id) REFERENCES dog_breed (id);