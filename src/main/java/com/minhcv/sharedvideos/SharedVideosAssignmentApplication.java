package com.minhcv.sharedvideos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SharedVideosAssignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(SharedVideosAssignmentApplication.class, args);
    }

}
