package com.studentmanage.repository;

import java.util.List;
import java.util.Optional;

import com.studentmanage.model.User;

public interface UserService {
    User saveUser(User user);
    Optional<User> findByUsername(String username);
    List<User> getAllUsers();
    void deleteUser(Long id);
    Optional<User> getUserById(Long id);
}

