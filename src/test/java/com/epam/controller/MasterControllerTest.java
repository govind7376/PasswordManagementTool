package com.epam.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(MasterController.class)
@ContextConfiguration(classes = {MasterController.class})
class MasterControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void testMenuForm() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("menu"));
    }

    @Test
    void testMasterLoginForm() throws Exception {
        mockMvc.perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect(view().name("master"));
    }

    @Test
    void testCheckMasterInformation() throws Exception {
        mockMvc.perform(get("/saveMaster?administratorName=admin&administratorPassword=12345"))
                .andExpect(status().isOk())
                .andExpect(view().name("menu"));
    }
}
