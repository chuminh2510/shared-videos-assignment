package com.minhcv.sharedvideos.controller;

import com.minhcv.sharedvideos.model.SharedVideo;
import com.minhcv.sharedvideos.service.SharedVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * @author minh.chu
 * @since 03/04/2023
 */
@Controller
@RequestMapping("")
public class PageController {

    @Autowired
    private SharedVideoService sharedVideoService;

    @GetMapping("/")
    String defaultPage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        Collection<SharedVideo> sharedVideos = sharedVideoService.list();
        model.addAttribute("sharedVideos", sharedVideos);
        return "home";
    }

    @GetMapping("/home")
    String homePage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        Collection<SharedVideo> sharedVideos = sharedVideoService.list();
        model.addAttribute("sharedVideos", sharedVideos);
        return "home";
    }

    @GetMapping("/user-registration")
    String userRegistrationPage() {
        return "pages/user_registration";
    }

    @GetMapping("/share-video")
    String shareVideoPage() {
        return "pages/share_video";
    }

    private void getHomePageInfo(UserDetails userDetails, Model model) {

        Collection<SharedVideo> sharedVideos = sharedVideoService.list();
        if (userDetails != null) {
            String username = userDetails.getUsername();
            sharedVideos.forEach(sharedVideo -> {
                if (sharedVideo.getVotes().containsKey(username)) {
                    sharedVideo.setSelfVote(sharedVideo.getVotes().get(username));
                }
            });
        }

        model.addAttribute("sharedVideos", sharedVideos);
    }
}
