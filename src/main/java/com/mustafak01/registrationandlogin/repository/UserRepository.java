package com.mustafak01.registrationandlogin.repository;

import com.mustafak01.registrationandlogin.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserModel,Long>{
    UserModel findByUserName(String userName);
    UserModel findByEmail(String email);
}

