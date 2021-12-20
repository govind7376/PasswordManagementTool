package com.epam.controller;
import com.epam.entity.Group;
import com.epam.exception.NoGroupFoundForAccount;
import com.epam.exception.NoRecordFoundForGroup;
import com.epam.service.AccountService;
import com.epam.service.GroupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class GroupController {
    @Autowired
    GroupService groupService;
    @Autowired
    AccountService accountService;

    @RequestMapping("listofgroups")
    public ModelAndView displayListOfGroups() throws NoGroupFoundForAccount {
        ModelAndView mv = new ModelAndView();
        List<Group> groups=groupService.findAllGroups();
        mv.setViewName("displaylistofgroups");
        mv.addObject("groups", groups);
        return mv;
    }

    @GetMapping("inputGroupName")
    public String inputGroupName() {
        return "inputgroupname";
    }

    @RequestMapping("displayAllRecordsByGroupName")
    public ModelAndView displayAllRecordByGroupName(String groupName) throws NoRecordFoundForGroup {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("displayallrecordsbygroupname");
        mv.addObject("accounts", groupService.findAllRecordByGroupName(groupName));
        return mv;
    }

    @RequestMapping("inputUpdateGroupName")
    public String inputUpdateGroupName()  {
        return "inputupdategroupname";
    }

    @RequestMapping("updateGroupName")
    public String updateGroupName(String oldGroupName, String newGroupName) throws NoGroupFoundForAccount {
        if (groupService.updateGroup(newGroupName, oldGroupName))
        return  "success";
      return "error";
    }

    @RequestMapping("inputDeleteGroupName")
    public String takeDeleteGroupName() {
        return "inputdeletegroupname";
    }

    @RequestMapping("deleteGroupName")
    public String deleteGroupName(String groupName) throws NoGroupFoundForAccount {
        boolean isUpdated = groupService.deleteGroup(groupName);
        if (isUpdated)
            return  "success";
        return "error";
    }

    @RequestMapping("inputDeleteUserAccount")
    public String inputDeleteUserAccount()   {
        return "inputdeleteuseraccount";
    }

    @RequestMapping("deleteUserAccount")
    public String deleteUserAccount(String userAccountName, String groupName) throws NoGroupFoundForAccount {

        boolean isAccountDeleted = accountService.deleteAccountFromGroup(userAccountName, groupName);

        if (isAccountDeleted)
            return  "success";
        return "error";
    }

    @RequestMapping("inputUpdatePasswordFromAccount")
    public String inputUpdatePasswordFromAccount(){
        return "inputupdatepasswordfromaccount";
    }

    @RequestMapping("updatePasswordFromAccount")
    public String updatePasswordFromAccount(String userName, String groupName, String newPassword) throws NoGroupFoundForAccount {
        boolean isPasswordUpdated = accountService.updatePasswordFromUserAccount(groupName, userName, newPassword);

        if (isPasswordUpdated)
            return  "success";
        return "error";
    }

    @RequestMapping("inputRetrievalPasswordFromUserAccount")
    public String inputRetrievalPasswordFromUserAccount(){
        return "inputretrievalpasswordfromuseraccount";
    }

    @RequestMapping("retrievalPasswordFromUserAccount")
    public ModelAndView retrievalPasswordFromUserAccount(String userAccountName, String groupName) throws NoGroupFoundForAccount {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("retrievalpasswordfromuseraccount");
        mv.addObject("password", accountService.retrievalPassword(userAccountName, groupName));
        return mv;

    }

}
