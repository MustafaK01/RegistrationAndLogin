package com.mustafak01.registrationandlogin.service;

import com.mustafak01.registrationandlogin.model.response.AuthResponseLogin;
import com.mustafak01.registrationandlogin.model.requests.LoginRequest;

public interface LoginService {
    AuthResponseLogin login(LoginRequest loginRequest);
}
