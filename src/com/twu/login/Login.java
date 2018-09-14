package com.twu.login;

import com.twu.user.User;
import com.twu.utils.Dictionary;

import java.util.List;


public class Login {
    public User currentUser;
    private Dictionary dictionary;
    private List<User>userList;

    public Login() {
    }

    public Login(List<User>userList){
        this.userList=userList;
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
