package com.mustafak01.registrationandlogin.service;

import com.mustafak01.registrationandlogin.model.RegistrationRequest;
import com.mustafak01.registrationandlogin.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {
    public String saveUser(RegistrationRequest registrationRequest){
        return "Successful";
    }
}
