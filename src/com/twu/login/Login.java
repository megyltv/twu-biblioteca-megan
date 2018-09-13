package com.twu.login;

import com.twu.utils.Dictionary;

import java.util.ArrayList;
import java.util.List;

public class Login {
    public User currentUser;
    public List<User> userList;
    private Dictionary dictionary;

    public Login(){
        userList=createUsers();
        currentUser=new User();
    }

    public boolean compareUser(String idLibraryCode,User user){
        if(user.getIdLibraryCode().equals(idLibraryCode)){
            return true;
        }

        return false;
    }

    public boolean compareCredentials(String idLibraryCode,String password){
        for (User user:userList) {
            if (compareUser(idLibraryCode, user) && user.getPassword().equals(password)) {
                this.currentUser = user;
                return true;
            }
        }


        return false;
    }

    public List<User> createUsers(){
        userList=new ArrayList<User>();
        userList.add(new User("123-1235", "passwd", "Mary", "mar@ej.com", "20983950"));
        userList.add(new User("123-1236", "passwd1", "John", "john@ej.com", "20983951"));
        userList.add(new User("123-1237", "passwd2", "Anna", "anna@ej.com", "20983952"));

        return userList;
    }

    public String showMessageIfIncorrect(boolean received){
        String messageReceivedIfIncorrect="";
        if(!received){
            messageReceivedIfIncorrect=dictionary.MESSAGE_LOGIN_INCORRECT;
        }
        return messageReceivedIfIncorrect;
    }

    public User getCurrentUser(){
        return this.currentUser;
    }

    public User logOut(){
        this.currentUser=null;
        return this.currentUser;
    }
}
