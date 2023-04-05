package com.minhcv.sharedvideos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author minh.chu
 * @since 04/04/2023
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class YoutubeResponse {
    private String kind;
    private String etag;
    private List<VideoInfo> items;
    private PageInfo pageInfo;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class VideoInfo {
        private String id;
        private SnippetInfo snippet;
        private StatisticsInfo statistics;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SnippetInfo {
        private String title;
        private String description;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class StatisticsInfo {
        private int viewCount;
        private int likeCount;
        private int favoriteCount;
        private int commentCount;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class PageInfo {
        private Integer totalResults;
        private Integer resultsPerPage;
    }
}
