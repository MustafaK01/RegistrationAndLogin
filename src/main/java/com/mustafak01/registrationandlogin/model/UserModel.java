package com.mustafak01.registrationandlogin.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class UserModel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;
    private String password;
    private String email;


    public UserModel(Long id, String userName,String password,String email) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }
}
