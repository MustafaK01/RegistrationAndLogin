package com.mustafak01.registrationandlogin.service;

import com.mustafak01.registrationandlogin.model.requests.RegistrationRequest;
import org.springframework.http.ResponseEntity;

public interface RegistrationService {
    boolean checkUserIfExists(String username,String email);
    ResponseEntity<String> saveUser(RegistrationRequest registrationRequest);
}
