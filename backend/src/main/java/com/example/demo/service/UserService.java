package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    
    private List<User> users = new ArrayList<>();
    private Long nextId = 1L;

    public UserService() {
        // Initialize with some sample data
        users.add(new User("John Doe", "john@example.com"));
        users.add(new User("Jane Smith", "jane@example.com"));
        users.get(0).setId(nextId++);
        users.get(1).setId(nextId++);
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User getUserById(Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public User createUser(User user) {
        user.setId(nextId++);
        users.add(user);
        return user;
    }

    public User updateUser(Long id, User userDetails) {
        User user = getUserById(id);
        if (user != null) {
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
        }
        return user;
    }

    public boolean deleteUser(Long id) {
        return users.removeIf(user -> user.getId().equals(id));
    }
}