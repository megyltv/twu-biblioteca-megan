package com.twu.user;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String idLibraryCode;
    private String password;
    private String nameUser;
    private String emailAddress;
    private String phoneNumber;
    private Role role;

    public enum Role {
        LIBRARIAN, CUSTOMER
    }

    public User() {
    }

    public User(String idLibraryCode, String password, String nameUser, String emailAddress, String phoneNumber, Role role) {
        this.idLibraryCode = idLibraryCode;
        this.password = password;
        this.nameUser = nameUser;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.role=role;
    }

    public String getPassword() {
        return password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getIdLibraryCode() {
        return idLibraryCode;
    }

    public List<User> createUsers(){
        List<User> userList=new ArrayList<User>();
        userList.add(new User("123-1235", "passwd", "Mary", "mar@ej.com", "20983950",Role.LIBRARIAN));
        userList.add(new User("123-1236", "passwd1", "John", "john@ej.com", "20983951",Role.CUSTOMER));
        userList.add(new User("123-1237", "passwd2", "Anna", "anna@ej.com", "20983952",Role.CUSTOMER));

        return userList;
    }

    public Role getRole() {
        return role;
    }

    public String getNameUser() {
        return nameUser;
    }
}
