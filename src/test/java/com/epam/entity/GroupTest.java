package com.epam.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupTest {
    Group group;
    @BeforeEach
    void setup() {
        group = new Group();
    }
    @Test
    public void testGroupName(){
      group.setGroupName("rahul");
        assertEquals("rahul", group.getGroupName());
    }




}
