package com.charlesreilly.lifedashboard.service.impl;

import com.charlesreilly.lifedashboard.model.User;
import com.charlesreilly.lifedashboard.repository.UserRepository;
import com.charlesreilly.lifedashboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user){
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> getUserByUsername(String username){
        return userRepository.findByUsername(username);
    }


    @Override
    public User updateUser(Long id, User user){
        Optional<User> existingUser = userRepository.findById(id);
        if(existingUser.isPresent()){
            user.setId(id);
            return userRepository.save(user);
        }
        else{
            return null;
        }
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
