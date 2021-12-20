package com.epam.entity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

  class AccountTest {
    Account account;
    @BeforeEach
    void setup() {
     account = new Account();
    }
    @Test
    void testUserName(){
        account.setUserName("rahul");
        assertEquals("rahul", account.getUserName());
    }
    @Test
    void testUrl(){
        account.setUrl("www.google.com");
        assertEquals("www.google.com", account.getUrl());
    }
    @Test
    void testPassword(){
        account.setPassword("@#123rahul");
        assertEquals("@#123rahul", account.getPassword());
    }
}
