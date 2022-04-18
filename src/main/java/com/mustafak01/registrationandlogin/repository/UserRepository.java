package com.mustafak01.registrationandlogin.repository;

import com.mustafak01.registrationandlogin.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserModel,Long>{
    Optional<UserModel> findByEmail(String email);
}

