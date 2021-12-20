package com.epam.controller;

import com.epam.entity.Account;
import com.epam.entity.Group;
import com.epam.service.AccountService;
import com.epam.service.GroupService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(GroupController.class)
@ContextConfiguration(classes = {GroupController.class})
class GroupControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    GroupService groupService;

    @MockBean
    AccountService accountService;


    @Test
    void testInputGroupName() throws Exception {
        mockMvc.perform(get("/inputGroupName"))
                .andExpect(status().isOk())
                .andExpect(view().name("inputgroupname"));
    }


    @Test
    void testDisplayListOfGroups() throws Exception {
        List<Group> groups = new ArrayList<>();
        when(groupService.findAllGroups()).thenReturn(groups);
        mockMvc.perform(get("/listofgroups"))
                .andExpect(status().isOk())
                .andExpect(view().name("displaylistofgroups"));
    }

    @Test
    void testDisplayAllRecordByGroupName() throws Exception {
        List<Account> groups = new ArrayList<>();
        when(groupService.findAllRecordByGroupName("rahul")).thenReturn(groups);
        mockMvc.perform(get("/displayAllRecordsByGroupName?rahul"))
                .andExpect(status().isOk())
                .andExpect(view().name("displayallrecordsbygroupname"));
    }

    @Test
    void testInputUpdateGroupName() throws Exception {
        mockMvc.perform(get("/inputUpdateGroupName"))
                .andExpect(status().isOk())
                .andExpect(view().name("inputupdategroupname"));
    }

    @Test
    void testUpdateGroupName() throws Exception {

        when(groupService.updateGroup("ram", "rahul")).thenReturn(true);
        mockMvc.perform(get("/updateGroupName?oldGroupName= rahul &newGroupName=ram"))
                .andExpect(status().isOk())
                .andExpect(view().name("error"));
    }

    @Test
    void testTakeDeleteGroupName() throws Exception {
        mockMvc.perform(get("/inputDeleteGroupName"))
                .andExpect(status().isOk())
                .andExpect(view().name("inputdeletegroupname"));
    }

    @Test
    void testDeleteGroupName() throws Exception {

        when(groupService.deleteGroup("ram")).thenReturn(true);
        mockMvc.perform(get("/deleteGroupName? ram"))
                .andExpect(status().isOk())
                .andExpect(view().name("error"));
    }

    @Test
    void testInputDeleteUserAccount() throws Exception {
        mockMvc.perform(get("/inputDeleteUserAccount"))
                .andExpect(status().isOk())
                .andExpect(view().name("inputdeleteuseraccount"));
    }

    @Test
    void tesDeleteUserAccount() throws Exception {

        when(groupService.updateGroup("ram", "rahul")).thenReturn(true);
        mockMvc.perform(get("/deleteUserAccount?userAccountName= rahul &groupName=ram"))
                .andExpect(status().isOk())
                .andExpect(view().name("error"));
    }

    @Test
    void testInputUpdatePasswordFromAccount() throws Exception {
        mockMvc.perform(get("/inputUpdatePasswordFromAccount"))
                .andExpect(status().isOk())
                .andExpect(view().name("inputupdatepasswordfromaccount"));
    }

    @Test
    void testUpdatePasswordFromAccount() throws Exception {

        when(accountService.updatePasswordFromUserAccount("ram", "rahul", "qwerty@#")).thenReturn(true);
        mockMvc.perform(get("/updatePasswordFromAccount?oldGroupName= rahul &newGroupName=ram& newPassword=qwerty@#"))
                .andExpect(status().isOk())
                .andExpect(view().name("error"));
    }

    @Test
    void testInputRetrievalPasswordFromUserAccount() throws Exception {
        mockMvc.perform(get("/inputRetrievalPasswordFromUserAccount"))
                .andExpect(status().isOk())
                .andExpect(view().name("inputretrievalpasswordfromuseraccount"));
    }

    @Test
    void testRetrievalPasswordFromUserAccount() throws Exception {
        String password = "qwerty123";
        when(accountService.retrievalPassword("ram", "rahul")).thenReturn(password);
        mockMvc.perform(get("/updatePasswordFromAccount?oldGroupName= rahul &newGroupName=ram& newPassword=qwerty@#"))
                .andExpect(status().isOk())
                .andExpect(view().name("error"));
    }


}
