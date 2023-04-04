package com.minhcv.sharedvideos.service;

import com.minhcv.sharedvideos.dto.UserDto;
import com.minhcv.sharedvideos.model.User;
import com.minhcv.sharedvideos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author minh.chu
 * @since 03/04/2023
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User register(UserDto userDto) {
        return userRepo.registerUser(userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()));
    }
}
