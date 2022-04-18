package com.mustafak01.registrationandlogin.service;

import com.mustafak01.registrationandlogin.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private static final String MESSAGE = "User Not Found : %s";

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.
                findByEmail(email).
                orElseThrow(() -> new UsernameNotFoundException(String.format(MESSAGE,email)));
    }
}
