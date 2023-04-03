package com.minhcv.sharedvideos.repository;

import com.minhcv.sharedvideos.model.SharedVideo;

import java.util.List;
import java.util.Map;

/**
 * @author minh.chu
 * @since 03/04/2023
 */
public class SharedVideoRepository {
    // <VideoID, Video Info>
    private Map<String, SharedVideo> sharedVideos;
}
