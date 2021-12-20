package com.epam.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
  class RegisterDTOTest {
    RegisterDTO registerDTO;

    @BeforeEach
    void setup() {
        registerDTO = new RegisterDTO();
    }

    @Test
    void testUserName() {
        registerDTO.setUserName("KGR009517");
        assertEquals("KGR009517",registerDTO.getUserName());
    }

    @Test
    void testPassword() {
        registerDTO.setPassword("Vishal834019");
        assertEquals("Vishal834019",registerDTO.getPassword());
    }

    @Test
    void testUrl() {
        registerDTO.setUrl("http://www.mastercard.com");
        assertEquals("http://www.mastercard.com", registerDTO.getUrl());
    }

    @Test
    void testNotes() {
        registerDTO.setGroupName("Google");
        assertEquals("Google", registerDTO.getGroupName());
    }
}
