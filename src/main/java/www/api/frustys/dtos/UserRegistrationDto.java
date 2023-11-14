package www.api.frustys.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegistrationDto {
    private String lastname;
    private String firstname;
    private String email;
    private String password;
    private String phonenumber;
    private String roles;
    private String address;
}
