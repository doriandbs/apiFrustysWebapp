package www.api.frustys.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www.api.frustys.dtos.UserRegistrationDto;
import www.api.frustys.entities.User;
import www.api.frustys.security.CustomPasswordEncoder;
import www.api.frustys.services.interfaces.IUserService;
import www.api.frustys.services.repositories.interfaces.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private CustomPasswordEncoder passwordEncoder;

    @Override
    public List<User> getAllUser() {
        return (List<User>) userRepo.findAll();
    }

    @Override
    public User register(UserRegistrationDto userRegistration) {
        User user = new User();
        user.setFirstname(userRegistration.getFirstname());
        user.setLastname(userRegistration.getLastname());
        user.setEmail(userRegistration.getEmail());
        user.setPassword(passwordEncoder.encode(userRegistration.getPassword()));
        user.setEmail(userRegistration.getEmail());
        user.setPhonenumber(userRegistration.getPhonenumber());
        user.setAddress(userRegistration.getAddress());
        user.setRoles("USER");
        return userRepo.save(user);
    }
}
