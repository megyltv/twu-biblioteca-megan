package com.twu.library;

import com.twu.user.User;


public class Items {
    private User user;
    private String nameItem;

    public Items(User user, String nameItem) {
        this.user = user;
        this.nameItem = nameItem;
    }

    public User getUser() {
        return user;
    }

    public String getNameItem() {
        return nameItem;
    }
}
