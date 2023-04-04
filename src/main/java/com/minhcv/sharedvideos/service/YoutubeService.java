package com.minhcv.sharedvideos.service;

import com.minhcv.sharedvideos.dto.YoutubeResponse;

/**
 * @author minh.chu
 * @since 03/04/2023
 */
public interface YoutubeService {
    YoutubeResponse findVideoById(String videoId);
}
