package com.mustafak01.registrationandlogin.service;

import com.mustafak01.registrationandlogin.model.requests.LoginRequest;

public interface LoginService {
    String login(LoginRequest loginRequest);
}
