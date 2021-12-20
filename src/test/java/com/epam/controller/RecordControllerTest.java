package com.epam.controller;

import com.epam.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.epam.dto.RegisterDTO;


@WebMvcTest(RecordController.class)
@ContextConfiguration(classes = {RecordController.class})
class RecordControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    AccountService accountService;

    @Test
    void testMenuForm() throws Exception {
        mockMvc.perform(get("/registerAccount"))
                .andExpect(status().isOk())
                .andExpect(view().name("register"));
    }

    @Test
    void testCreateAccount() throws Exception {
        RegisterDTO registerDTO = new RegisterDTO("TATA", "Rahul", "www.leetcode.com", "#@*ui*&M");
        when(accountService.registerAccount(registerDTO)).thenReturn(true);
        mockMvc.perform(get("/createAccount?registerDTO"))
                .andExpect(status().isOk())
                .andExpect(view().name("error"));
    }
}
