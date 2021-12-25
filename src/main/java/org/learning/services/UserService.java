package org.learning.services;

import org.learning.entities.Role;
import org.learning.entities.User;
import org.learning.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public void createUser(User user) {
        user.setRole(Role.USER);
        userRepo.save(user);
    }
}
