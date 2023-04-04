package com.minhcv.sharedvideos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author minh.chu
 * @since 03/04/2023
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("")
    String home(Model model) {
        return "home";
    }
}
