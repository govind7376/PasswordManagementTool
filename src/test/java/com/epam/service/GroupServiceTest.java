package com.epam.service;

import com.epam.dao.GroupDao;
import com.epam.entity.Account;
import com.epam.entity.Group;
import com.epam.exception.NoGroupFoundForAccount;
import com.epam.exception.NoRecordFoundForGroup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
  class GroupServiceTest {
    @InjectMocks
   GroupService groupService;
    @Mock
    GroupDao groupDao;
    @Test
   void testGroupExistOrNot() throws NoGroupFoundForAccount {
        when(groupDao.containsGroup("Rahul")).thenReturn(true);
        Assertions.assertDoesNotThrow(() ->groupService.groupExistOrNot("Rahul"));
    }

    @Test
   void testFindAllRecordByGroupName() throws NoRecordFoundForGroup {
        List<Account>accounts=new ArrayList<>();
        when(groupDao.displayAllRecordByGroupName("Rahul")).thenReturn(accounts);
        Assertions.assertDoesNotThrow(()->groupService.findAllRecordByGroupName("Rahul"));
    }
    @Test
   void testUpdateGroup() throws NoGroupFoundForAccount {
       when(groupDao.updateGroupName("Raju", "Rahul")).thenReturn(true);
        Assertions.assertDoesNotThrow(()->groupService. updateGroup("Raju", "Rahul"));
    }
    @Test
     void  testFindAllGroups() throws NoGroupFoundForAccount {
        List<Group>groups=new ArrayList<>();
        when(groupDao.displayListOfGroups()).thenReturn(groups);
        Assertions.assertDoesNotThrow(()->groupService.findAllGroups());

    }
    @Test
      void  testDeleteGroup() throws NoGroupFoundForAccount {

        when( groupDao.deleteGroupName("rahul")).thenReturn(true);
        Assertions.assertDoesNotThrow(()->groupService.deleteGroup("rahul"));

    }

}
