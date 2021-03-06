package com.mustafak01.registrationandlogin.model.response;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AuthResponseLogin {
    String message;
    String token;
    Long userId;
    Long expirationDate;
    String email;
    boolean isSuccess;
}
