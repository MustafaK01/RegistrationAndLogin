package com.mustafak01.registrationandlogin.controller;

import com.mustafak01.registrationandlogin.model.RegistrationRequest;
import com.mustafak01.registrationandlogin.model.UserModel;
import com.mustafak01.registrationandlogin.repository.UserRepository;
import com.mustafak01.registrationandlogin.service.RegistrationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.Registration;
import java.util.SimpleTimeZone;

@Slf4j
@RestController
@RequestMapping("/api/registration")
@AllArgsConstructor
public class UserRegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    public String register(@RequestBody RegistrationRequest registrationRequest){
        log.info(String.format("Registered %s",registrationRequest));
        return registrationService.saveUser(registrationRequest);
    }
}
