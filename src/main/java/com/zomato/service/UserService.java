package com.zomato.service;

import com.zomato.model.User;

public interface UserService {
    User findUserByJwtToken(String jwt) throws Exception;

    User findUserByEmail(String email) throws Exception;
}
