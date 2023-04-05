package com.minhcv.sharedvideos.controller;

import com.minhcv.sharedvideos.model.SharedVideo;
import com.minhcv.sharedvideos.service.SharedVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    private SharedVideoService youtubeService;

    @PostMapping("/{id}")
    public SharedVideo shareVideo(@AuthenticationPrincipal UserDetails userDetails, @PathVariable String id) throws Exception {
        String username = userDetails.getUsername();
        return youtubeService.shareVideo(username, id);
    }
}
