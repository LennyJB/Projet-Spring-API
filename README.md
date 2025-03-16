# Projet-Spring-API

Remplir le .properties avec ça :

```
spring.application.name=ProjetSpringAPI
server.port=8081
spring.datasource.url=jdbc:mysql://localhost:3306/projet_spring_api
spring.datasource.username=root
spring.datasource.password=
spring.jpa.generate-ddl=true
logging.level.org.springframework.security=DEBUG
cors.allowedOrigins=http://localhost:8080,http://192.168.1.167:8080
jwt.secret=jugbbyuiunefzrgrhttgrerhtrhertyutredfvfbgnhjuytrefvbgnhjytrfghyrtgfhtyrgfhtyrghtyrgfhytrgfbh
spring.jpa.hibernate.ddl-auto=none
spring.jpa.properties.javax.persistence.schema-generation.scripts.action=create
spring.jpa.properties.javax.persistence.schema-generation.scripts.create-target=create.sql
spring.jpa.properties.javax.persistence.schema-generation.database.action=none
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.flyway.locations=classpath:db/migration,classpath:db/migration/testdata
spring.flyway.enabled=true
spring.flyway.out-of-order=true
```

Ensuite il faut créé la base de données mysql avec comme nom projet_spring_api.

Pour finir lancer l'application et tout devrait marcher.

Les requêtes possibles sont dans le dossier Collection-BRUNO.

Pour les requêtes, il faudra mettre le token créé lors du login avec un utilisateur par exemple pour l'utilisateur UserCrud pour toutes les requêtes CRUD.

Les mots de passe des 3 utilisateurs créés sont "password".
