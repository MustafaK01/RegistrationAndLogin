package com.mustafak01.registrationandlogin.service;

import com.mustafak01.registrationandlogin.model.UserModel;
import com.mustafak01.registrationandlogin.model.requests.RegistrationRequest;
import com.mustafak01.registrationandlogin.model.response.AuthResponseRegister;
import com.mustafak01.registrationandlogin.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationManager implements RegistrationService {


    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;

    @Override
    public boolean checkUserIfExists(String username,String email) {
        if(userRepository.findByUserName(username)!=null || userRepository.findByEmail(email)!=null){
            return false;//
        }
        return true;
    }

    public ResponseEntity<AuthResponseRegister> saveUser(RegistrationRequest registrationRequest){
        AuthResponseRegister authResponse = new AuthResponseRegister();
        if(!(checkUserIfExists(registrationRequest.getUserName()
                ,registrationRequest.getEmail()))){
            authResponse.setMessage("User Already Registered");
            authResponse.setSuccess(false);
            return new ResponseEntity<>(authResponse, HttpStatus.BAD_REQUEST);
        }
        UserModel user = new UserModel();
        user.setUserName(registrationRequest.getUserName());
        user.setEmail(registrationRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
        authResponse.setMessage("User Registered");
        authResponse.setSuccess(true);
        userRepository.save(user);
        return new ResponseEntity<>(authResponse,HttpStatus.CREATED);
    }
}
