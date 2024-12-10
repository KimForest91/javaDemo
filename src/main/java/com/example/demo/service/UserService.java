package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.model.UserPhonesVO;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();    
    User getUserById(Long id);
    List<UserPhonesVO> getAllUsersPhones();
    void insertUsers(User user);
    User updateUser(User user);
    void deleteUser(Long id);
}
