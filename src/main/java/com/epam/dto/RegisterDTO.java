package com.epam.dto;

public class RegisterDTO {
    private String groupName;
    private String userName;
    private String url;
    private String password;

    public RegisterDTO() {
    }
    public RegisterDTO(String groupName, String userName, String url, String password) {
        this.groupName = groupName;
        this.userName = userName;
        this.url = url;
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPassword() {
        return password;
    }

}
