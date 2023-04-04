package com.minhcv.sharedvideos.controller;

import com.minhcv.sharedvideos.dto.YoutubeResponse;
import com.minhcv.sharedvideos.service.YoutubeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author minh.chu
 * @since 03/04/2023
 */

@RestController
@RequestMapping("/videos")
public class VideoController {
    @Autowired
    private YoutubeService youtubeService;

    @GetMapping("/{id}")
    public YoutubeResponse findById(@PathVariable("id") String id){
        return youtubeService.findVideoById(id);

    }
}
