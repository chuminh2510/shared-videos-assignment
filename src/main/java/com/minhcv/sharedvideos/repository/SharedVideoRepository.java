package com.minhcv.sharedvideos.repository;

import com.minhcv.sharedvideos.model.SharedVideo;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author minh.chu
 * @since 03/04/2023
 */

@Repository
public class SharedVideoRepository {
    // <VideoID, Video Info>
    private Map<String, SharedVideo> sharedVideos;

    @PostConstruct
    void init() {
        sharedVideos = new HashMap<>();
    }

    public Collection<SharedVideo> list() {
        return sharedVideos.values();
    }

    public SharedVideo add(String id, SharedVideo sharedVideo) {
        return sharedVideos.put(id, sharedVideo);
    }
}
