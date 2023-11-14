package www.api.frustys.services.interfaces;

import www.api.frustys.dtos.UserRegistrationDto;
import www.api.frustys.entities.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUser();
    User register(UserRegistrationDto user);
}
