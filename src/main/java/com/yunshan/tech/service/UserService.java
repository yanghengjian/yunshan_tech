package com.yunshan.tech.service;

import com.yunshan.tech.model.User;

public interface UserService {
    User login(String username, String password);

    void logout(Long userId);

    boolean isValidToken(String token);
}
