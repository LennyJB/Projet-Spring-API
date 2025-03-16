package efrei.projetspringapi.controller;


import efrei.projetspringapi.service.DogService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/api/rebond")
public class RebondController {

    private final DogService rebondService;

    public RebondController(DogService rebondService) {
        this.rebondService = rebondService;
    }

    @GetMapping("/random-dog")
    @PreAuthorize("hasAuthority('REBOND')")
    public ResponseEntity<Map<String, String>> getRandomDogImage() {
        Map<String, String> response = rebondService.requestRandomDog();
        return ResponseEntity.ok(response);
    }
}
