package com.mustafak01.registrationandlogin.service;

import com.mustafak01.registrationandlogin.model.UserModel;
import com.mustafak01.registrationandlogin.model.requests.RegistrationRequest;
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

    public ResponseEntity<String> saveUser(RegistrationRequest registrationRequest){
        if(!(checkUserIfExists(registrationRequest.getUserName()
                ,registrationRequest.getEmail()))){
            return new ResponseEntity<>("User already exists", HttpStatus.BAD_REQUEST);
        }
        UserModel user = new UserModel();
        user.setUserName(registrationRequest.getUserName());
        user.setEmail(registrationRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
        user.setName(registrationRequest.getFirstName()+" "+registrationRequest.getLastName());
        userRepository.save(user);
        return new ResponseEntity<>("User Registered",HttpStatus.CREATED);
    }
}
