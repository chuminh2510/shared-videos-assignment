package com.minhcv.sharedvideos.config;

import com.minhcv.sharedvideos.model.User;
import com.minhcv.sharedvideos.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author minh.chu
 * @since 06/04/2023
 */
public class UserExistsBeforeAuthenticationFilter extends GenericFilterBean {
    private UserRepository userRepo;
    private PasswordEncoder passwordEncoder;

    public UserExistsBeforeAuthenticationFilter(UserRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        String username = httpRequest.getParameter("username");
        String password = httpRequest.getParameter("password");
        if (StringUtils.hasText(username)) {
            User user = userRepo.getByEmail(username);
            if (user == null && StringUtils.hasText(password)) {
                userRepo.registerUser(username.trim(), passwordEncoder.encode(password));
            }
        }
        chain.doFilter(request, response);
    }
}
