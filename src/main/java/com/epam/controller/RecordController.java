package com.epam.controller;

import com.epam.dto.RegisterDTO;
import com.epam.exception.AccountAlreadyExistsException;
import com.epam.exception.NoGroupFoundForAccount;
import com.epam.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecordController {
    @Autowired
    AccountService accountService;


    @RequestMapping("registerAccount")
    public String registerAccount() {
        return "register";
    }

    @RequestMapping("createAccount")
    public String createAccount(RegisterDTO register) throws AccountAlreadyExistsException, NoGroupFoundForAccount {
        String result = "error";
        if (accountService.registerAccount(register))
            result = "success";
        return result;
    }


}
