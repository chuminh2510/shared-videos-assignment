package com.minhcv.sharedvideos.model;

import com.minhcv.sharedvideos.dto.YoutubeResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author minh.chu
 * @since 03/04/2023
 */

@Getter
@Setter
public class SharedVideo {
    @Getter
    public enum VoteType {
        UP,
        DOWN;
    }

    private String id;
    private String title;
    private String sharedBy;
    private int votedUpCount;
    private int votedDownCount;
    // <Email, VoteType>
    private Map<String, VoteType> votes;
    private String description;
    private String url;

    private Date sharedAt;

    private VoteType selfVote;

    public SharedVideo(YoutubeResponse.VideoInfo info) {
        this.id = info.getId();
        this.title = info.getSnippet().getTitle();
        this.description = info.getSnippet().getDescription();
        this.votedUpCount = 0;
        this.votedDownCount = 0;
        this.votes = new HashMap<>();
        this.url = "https://www.youtube.com/embed/" + info.getId();
        this.sharedAt = new Date();
    }
}
