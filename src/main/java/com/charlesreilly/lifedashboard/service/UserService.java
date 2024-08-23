package com.charlesreilly.lifedashboard.service;


import com.charlesreilly.lifedashboard.model.User;

import java.util.Optional;

public interface UserService {

    User createUser(User user);
    Optional<User> getUserById(Long id);
    Optional<User> getUserByUsername(String username);

    User updateUser(Long id, User user);

    void deleteUser(Long id);
}
