package com.epam.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Group_Table")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     int groupId;

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    private String groupName;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    List<Account> userAccounts;

    public List<Account> getUserAccounts() {
        return userAccounts;
    }

    public void setUserAccounts(List<Account> userAccounts) {
        userAccounts.forEach(userAccount ->userAccount.setGroup(this));
        this.userAccounts = userAccounts;
    }


    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
