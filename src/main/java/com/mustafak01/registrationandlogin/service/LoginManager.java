package com.mustafak01.registrationandlogin.service;

import com.mustafak01.registrationandlogin.model.response.AuthResponseLogin;
import com.mustafak01.registrationandlogin.model.UserModel;
import com.mustafak01.registrationandlogin.model.requests.LoginRequest;
import com.mustafak01.registrationandlogin.repository.UserRepository;
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
    private UserRepository userRepository;
    public AuthResponseLogin login(LoginRequest loginRequest){
        UserModel userModel = userRepository.findByUserName(loginRequest.getUserName());
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginRequest.getUserName(),loginRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwtToken = tokenProviderJwt.generateToken(authentication);
        Long expirationDate = tokenProviderJwt.expirationDate(jwtToken);
        AuthResponseLogin authResponse = new AuthResponseLogin();
        authResponse.setSuccess(true);
        authResponse.setToken(jwtToken);
        authResponse.setMessage("Succesfully Logged In");
        authResponse.setUserId(userModel.getId());
        authResponse.setEmail(userModel.getEmail());
        authResponse.setExpirationDate(expirationDate);
        return authResponse;
    }
}
