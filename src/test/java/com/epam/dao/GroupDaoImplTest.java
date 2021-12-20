package com.epam.dao;
import com.epam.entity.Group;

import com.epam.repository.GroupRepository;
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
 class GroupDaoImplTest {

    @InjectMocks
    GroupDao groupDaoImpl;

    @Mock
    GroupRepository groupRepository;

 @Test
 void testContainsGroup(){

     when(groupRepository.existsByGroupName("Google")).thenReturn(true);
     Assertions.assertDoesNotThrow(() -> groupDaoImpl.containsGroup("Google"));
 }

    @Test
    void testDisplayListOfGroups(){
        List<Group> groupList = new ArrayList<>();
       when(groupRepository.findAll()).thenReturn(groupList);
        Assertions.assertDoesNotThrow(() -> groupDaoImpl.displayListOfGroups());
    }
    //52
    @Test
    void testDisplayAllRecordByGroupName(){

        when(groupRepository.existsByGroupName("Google")).thenReturn(true);
        Assertions.assertDoesNotThrow(() -> groupDaoImpl.displayAllRecordByGroupName("Google"));
    }

    //77
    @Test
      void  testUpdateGroupName(){
         List<Group> groupList = new ArrayList<>();
          when(groupRepository.findAll()).thenReturn(groupList);
         Assertions.assertDoesNotThrow(() -> groupDaoImpl.updateGroupName("GoogleSearch","Google"));
    }
    @Test
      void  testDeleteGroupName(){
        List<Group> groupList = new ArrayList<>();
        when(groupRepository.findAll()).thenReturn(groupList);
        Assertions.assertDoesNotThrow(() -> groupDaoImpl.deleteGroupName("Google"));
    }


}