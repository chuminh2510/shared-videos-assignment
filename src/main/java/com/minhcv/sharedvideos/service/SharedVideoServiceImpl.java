package com.minhcv.sharedvideos.service;

import com.minhcv.sharedvideos.api.YoutubeApi;
import com.minhcv.sharedvideos.dto.YoutubeResponse;
import com.minhcv.sharedvideos.model.SharedVideo;
import com.minhcv.sharedvideos.repository.SharedVideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collection;

/**
 * @author minh.chu
 * @since 03/04/2023
 */
@Service
public class SharedVideoServiceImpl implements SharedVideoService {

    @Value("${youtube.api_key}")
    private String API_KEY;

    @Autowired
    private YoutubeApi youtubeApi;

    @Autowired
    private SharedVideoRepository sharedVideoRepo;

    @Override
    public Collection<SharedVideo> list() {
        return sharedVideoRepo.list();
    }

    @Override
    public SharedVideo shareVideo(String sharedBy, String videoId) throws Exception {
        String fields = "snippet,contentDetails,statistics";
        YoutubeResponse youtubeResponse = youtubeApi.getVideoById(API_KEY, videoId, fields);
        if (youtubeResponse == null || CollectionUtils.isEmpty(youtubeResponse.getItems()) || youtubeResponse.getItems().size() > 1) {
            throw new Exception("Youtube video ID is not correct");
        }
        SharedVideo sharedVideo = new SharedVideo(youtubeResponse.getItems().get(0));
        sharedVideo.setSharedBy(sharedBy);
        sharedVideo.setUrl("https://www.youtube.com/embed/" + videoId);
        sharedVideoRepo.add(videoId, sharedVideo);
        return sharedVideo;
    }
}
