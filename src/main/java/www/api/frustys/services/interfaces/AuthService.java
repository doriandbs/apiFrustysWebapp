package www.api.frustys.services.interfaces;

import org.springframework.stereotype.Service;
import www.api.frustys.dtos.SignupRequestDto;
import www.api.frustys.dtos.UserDto;

@Service
public interface AuthService {

    UserDto createUser(SignupRequestDto signupRequest);
}
