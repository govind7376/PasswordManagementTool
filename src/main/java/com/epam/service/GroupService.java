package com.epam.service;

import com.epam.dao.GroupDao;
import com.epam.entity.Account;
import com.epam.entity.Group;
import com.epam.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    @Autowired
    GroupDao groupDao;

    public boolean groupExistOrNot(String groupName) throws NoGroupFoundForAccount {
        return groupDao.containsGroup(groupName);
    }

    public List<Account> findAllRecordByGroupName(String groupName) throws NoRecordFoundForGroup {
        return groupDao.displayAllRecordByGroupName(groupName);
    }

    public boolean updateGroup(String newGroupName, String oldGroupName) throws NoGroupFoundForAccount {
        return groupDao.updateGroupName(newGroupName, oldGroupName);
    }

    public List<Group> findAllGroups() throws NoGroupFoundForAccount {
        return groupDao.displayListOfGroups();
    }

    public boolean deleteGroup(String groupName) throws NoGroupFoundForAccount {
        return groupDao.deleteGroupName(groupName);

    }


}
