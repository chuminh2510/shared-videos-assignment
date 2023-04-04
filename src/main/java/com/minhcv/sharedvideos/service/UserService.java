package com.minhcv.sharedvideos.service;

import com.minhcv.sharedvideos.dto.UserDto;
import com.minhcv.sharedvideos.model.User;

/**
 * @author minh.chu
 * @since 03/04/2023
 */
public interface UserService {
    User register(UserDto userDto);
}
