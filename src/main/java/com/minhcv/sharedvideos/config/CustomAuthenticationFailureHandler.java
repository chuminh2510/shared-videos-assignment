package com.minhcv.sharedvideos.config;

import com.minhcv.sharedvideos.repository.UserRepository;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author minh.chu
 * @since 04/04/2023
 */
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private UserRepository userRepo;

    public CustomAuthenticationFailureHandler(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (userRepo.getByEmail(username) == null) {
            getRedirectStrategy().sendRedirect(request, response, "/user-registration?error");
        } else {
            super.onAuthenticationFailure(request, response, exception);
        }
    }
}
