package com.minhcv.sharedvideos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author minh.chu
 * @since 03/04/2023
 */
@Getter
@AllArgsConstructor
public class User {
    private final String email;
    private final String password;
}
