package www.api.frustys.dtos;

import lombok.Data;

@Data
public class AuthenticationRequestDto {
    private String email;
    private String password;
}
