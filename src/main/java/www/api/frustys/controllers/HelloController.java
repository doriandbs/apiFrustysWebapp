package www.api.frustys.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {
    @GetMapping("/testAuthenticate")
    public ResponseEntity<String> test(){
        return new ResponseEntity<>("Bien authentifié", HttpStatus.OK);
    }
}
