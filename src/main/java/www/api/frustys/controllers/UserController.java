package www.api.frustys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import www.api.frustys.dtos.UserRegistrationDto;
import www.api.frustys.entities.User;
import www.api.frustys.services.interfaces.IUserService;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {
    private IUserService userService;
    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/allUsers")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @PutMapping("/register")
    public ResponseEntity<User> register(@RequestBody UserRegistrationDto userRegistration){
        User user = userService.register(userRegistration);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
