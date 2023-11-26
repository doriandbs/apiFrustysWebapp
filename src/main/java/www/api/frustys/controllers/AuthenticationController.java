package www.api.frustys.controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import www.api.frustys.dtos.AuthenticationRequestDto;
import www.api.frustys.dtos.AuthenticationResponseDto;
import www.api.frustys.services.jwt.UserDetailsServiceImpl;
import www.api.frustys.utils.JwtUtil;

import java.io.IOException;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public AuthenticationResponseDto createAuthenticationToken(@RequestBody AuthenticationRequestDto authRequest
                                                                    ,HttpServletResponse response) throws IOException {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequest.getEmail(), authRequest.getPassword()
                    )
            );
        }catch (BadCredentialsException e){
            throw new BadCredentialsException("Incorrect username or password");
        }catch(DisabledException ex){
            response.sendError(HttpServletResponse.SC_NOT_FOUND,"User is not created, Register user first");
            return null;
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getEmail());
         final String jwt = jwtUtil.generateToken(userDetails.getUsername());
         return new AuthenticationResponseDto(jwt);
    }
}
