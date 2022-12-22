package com.ktu.xola.service;

import com.ktu.xola.exception.EmailAlreadyInUseException;
import com.ktu.xola.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user) throws EmailAlreadyInUseException;
    User updateUser(User user);
    List<User> findAllUsers();
    User findUserById(int userId);
    void deleteUser(int id);
}
