package com.minhcv.sharedvideos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author minh.chu
 * @since 04/04/2023
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Model model, String error, String logout, RedirectAttributes redirectAttributes) {
        String param = "";
        if (error != null) {
            redirectAttributes.addFlashAttribute("errLoginMsg", "Your username and password are invalid.");
        }
        if (logout != null) {
            redirectAttributes.addFlashAttribute("logoutMessage", "You have been logged out successfully.");
        }
        return "redirect:/";
    }
}
