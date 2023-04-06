package com.minhcv.sharedvideos.security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author minh.chu
 * @since 06/04/2023
 */

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SecurityTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
    }

    @DisplayName("Access URLs with authenticated user")
    @WithMockUser
    @ParameterizedTest
    @ValueSource(strings = {"/", "/home", "/share-video"})
    void testAuthenticatedUser(String url) throws Exception {
        mockMvc.perform(get(url))
                .andExpect(status().isOk());
    }

    @DisplayName("Cannot access URLs with unauthenticated user")
    @ParameterizedTest
    @ValueSource(strings = {"/share-video"})
    void testUnAccessibleUnauthenticatedUser(String url) throws Exception {
        mockMvc.perform(get(url))
                .andExpect(status().is3xxRedirection());
    }

    @DisplayName("Access URLs with unauthenticated user")
    @ParameterizedTest
    @ValueSource(strings = {"/", "/home"})
    void testAccessibleUnauthenticatedUser(String url) throws Exception {
        mockMvc.perform(get(url))
                .andExpect(status().isOk());
    }
}
