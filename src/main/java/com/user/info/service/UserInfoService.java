package com.user.info.service;

import com.user.info.entity.User;
import com.user.info.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserInfoService {

    @Autowired
    private UserRepository userRepository;
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        userRepository.findAll().forEach(books1 -> users.add(books1));
        return users;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }
}
