package com.minhcv.sharedvideos.api;

import com.minhcv.sharedvideos.dto.YoutubeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author minh.chu
 * @since 03/04/2023
 */

@Component
@FeignClient(name="youtube", url= "https://www.googleapis.com/youtube/v3")
public interface YoutubeApi {
    //TODO: Using open feign to connect to Youtube API
    @GetMapping("/videos")
    YoutubeResponse getVideoById(@RequestParam("key") String apiKey, @RequestParam("id") String videoId);
}
