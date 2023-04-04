package com.minhcv.sharedvideos.controller;

import com.minhcv.sharedvideos.dto.UserDto;
import com.minhcv.sharedvideos.model.User;
import com.minhcv.sharedvideos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author minh.chu
 * @since 03/04/2023
 */

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("")
    public User registerUser(UserDto userDto) {
        return userService.register(userDto);
    }
}
