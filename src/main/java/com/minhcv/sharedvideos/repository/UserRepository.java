package com.minhcv.sharedvideos.repository;

import com.minhcv.sharedvideos.model.User;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author minh.chu
 * @since 03/04/2023
 */
@Repository
public class UserRepository {
    Map<String, User> users;

    @PostConstruct
    void init() {
        users = new HashMap<>();
        users.put("admin@gmail.com", new User("admin@gmail.com", "$2a$10$.JFqhCHu2TYBHH1V5dh7ReWyr6amBkWboBCczqqsdNkqqalDbDZ2W"));
    }

    public User getByEmail(String email) {
        return users.get(email);
    }

    public User registerUser(String email, String password) {
        User user = new User(email, password);
        users.put(email, user);
        return user;
    }
}
