package com.zomato.service;

import com.zomato.config.JwtProvider;
import com.zomato.model.User;
import com.zomato.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;

    public UserServiceImpl(UserRepository userRepository, JwtProvider jwtProvider) {
        this.userRepository = userRepository;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public User findUserByJwtToken(String jwt) throws Exception {
        String emailFromJwtToken = jwtProvider.getEmailFromJwtToken(jwt);
        User userByEmail = findUserByEmail(emailFromJwtToken);
        return userByEmail;
    }

    @Override
    public User findUserByEmail(String email) throws Exception {
        User user = userRepository.findByEmail(email);
        if(user == null) {
            throw new Exception("User not found");
        }
        return user;
    }
}
