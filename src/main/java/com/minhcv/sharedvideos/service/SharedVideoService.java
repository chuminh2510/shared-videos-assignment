package com.minhcv.sharedvideos.service;

import com.minhcv.sharedvideos.model.SharedVideo;

import java.util.Collection;

/**
 * @author minh.chu
 * @since 03/04/2023
 */
public interface SharedVideoService {
    SharedVideo shareVideo(String sharedBy, String videoId) throws Exception;

    Collection<SharedVideo> list();
}
