package com.minhcv.sharedvideos.controller;

import com.minhcv.sharedvideos.model.SharedVideo;
import com.minhcv.sharedvideos.service.SharedVideoService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class HomeController {

    @Autowired
    private SharedVideoService sharedVideoService;

    @GetMapping("/")
    String defaultPage(Model model) {
        Collection<SharedVideo> sharedVideos = sharedVideoService.list();
        model.addAttribute("sharedVideos", sharedVideos);
        return "home";
    }

    @GetMapping("/home")
    String homePage(Model model) {
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
}
