package com.minhcv.sharedvideos.service;

import com.minhcv.sharedvideos.api.YoutubeApi;
import com.minhcv.sharedvideos.dto.YoutubeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author minh.chu
 * @since 03/04/2023
 */
@Service
public class YoutubeServiceImpl implements YoutubeService {

    @Value("${youtube.api_key}")
    private String API_KEY;

    @Autowired
    private YoutubeApi youtubeApi;

    @Override
    public YoutubeResponse findVideoById(String videoId) {
        String fields = "snippet,contentDetails,statistics";
        return (YoutubeResponse) youtubeApi.getVideoById(API_KEY, videoId, fields);
    }
}
