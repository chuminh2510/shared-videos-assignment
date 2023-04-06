package com.minhcv.sharedvideos.service;

import com.minhcv.sharedvideos.model.SharedVideo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author minh.chu
 * @since 03/04/2023
 */

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SharedVideoServiceImplTest {
    @Autowired
    private SharedVideoService sharedVideoService;


    @DisplayName("Share video successfully")
    @ParameterizedTest
    @ValueSource(strings = {"1UJpFahphko", "W3ykypuEbnU", "1UJpFahphko"})
    void testShareExistingVideo(String videoId) throws Exception {
        SharedVideo sharedVideo = sharedVideoService.shareVideo("testAdmin", videoId);
        Assertions.assertEquals(videoId, sharedVideo.getId());
    }

    @DisplayName("Share video failed with null value")
    @ParameterizedTest
    @NullSource
    void testShareNullVideo(String videoId) {
        Assertions.assertThrows(Exception.class, () -> sharedVideoService.shareVideo("testAdmin", videoId), "Youtube video ID is not correct");
    }

    @DisplayName("Share video failed with not-existing video")
    @ParameterizedTest
    @ValueSource(strings = {"", "not-exist-W3ykypuEbnU", "not-exist-1UJpFahphko"})
    void testShareNotExistVideo(String videoId) {
        Assertions.assertThrows(Exception.class, () -> sharedVideoService.shareVideo("testAdmin", videoId), "Youtube video ID is not correct");
    }
}
