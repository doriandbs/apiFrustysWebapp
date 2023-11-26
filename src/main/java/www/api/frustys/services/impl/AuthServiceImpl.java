package www.api.frustys.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import www.api.frustys.dtos.SignupRequestDto;
import www.api.frustys.dtos.UserDto;
import www.api.frustys.entities.UtilisateurEntity;
import www.api.frustys.repositories.interfaces.IUserRepository;
import www.api.frustys.services.interfaces.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDto createUser(SignupRequestDto signupRequest) {
        UtilisateurEntity user = new UtilisateurEntity();
        user.setEmail(signupRequest.getEmail());
        user.setName(signupRequest.getName());
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
        UtilisateurEntity createdUser = userRepository.save(user);
        UserDto newUser = new UserDto();
        newUser.setEmail(createdUser.getEmail());
        newUser.setName(createdUser.getName());
        newUser.setPassword(createdUser.getPassword());
        return newUser;
    }
}
