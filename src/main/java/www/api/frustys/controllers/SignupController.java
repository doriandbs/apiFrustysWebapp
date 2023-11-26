package www.api.frustys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import www.api.frustys.dtos.SignupRequestDto;
import www.api.frustys.dtos.UserDto;
import www.api.frustys.services.interfaces.AuthService;

@RestController
public class SignupController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody SignupRequestDto signupRequest){
        UserDto createdUser = authService.createUser(signupRequest);
        if(createdUser==null)
            return new ResponseEntity<>("User is not created, try again later.", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
}
