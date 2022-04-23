package com.mustafak01.registrationandlogin.service;

import com.mustafak01.registrationandlogin.model.requests.RegistrationRequest;
import com.mustafak01.registrationandlogin.model.response.AuthResponseRegister;
import org.springframework.http.ResponseEntity;

public interface RegistrationService {
    boolean checkUserIfExists(String username,String email);
    ResponseEntity<AuthResponseRegister> saveUser(RegistrationRequest registrationRequest);
}
