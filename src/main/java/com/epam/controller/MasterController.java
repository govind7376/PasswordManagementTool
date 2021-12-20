package com.epam.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MasterController {

    @RequestMapping("/")
    public String menuForm() {
        return "menu";
    }

    @RequestMapping("login")
    public String masterLoginForm() {
        return "master";
    }

    @RequestMapping("saveMaster")
    public String checkMasterInformation(String administratorName, String administratorPassword) {
        String result="";
        String admin="admin";
        String password="12345";
        if (administratorName.equals(admin) &&  administratorPassword.equals(password)) result = "menu";
        if(result.isEmpty())result="error";
        return result;
    }
}

