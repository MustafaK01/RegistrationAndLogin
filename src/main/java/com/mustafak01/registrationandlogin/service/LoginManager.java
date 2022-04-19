package com.mustafak01.registrationandlogin.service;

import com.mustafak01.registrationandlogin.model.requests.LoginRequest;
import com.mustafak01.registrationandlogin.security.TokenProviderJwt;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginManager implements LoginService {
    private AuthenticationManager authenticationManager;
    private TokenProviderJwt tokenProviderJwt;
    public String login(LoginRequest loginRequest){
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginRequest.getUserName(),loginRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwtToken = tokenProviderJwt.generateToken(authentication);
        return "Bearer "+jwtToken;
    }
}
