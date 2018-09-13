package com.twu.library;

import java.util.List;

public interface ItemLibrary {
    public String showListItem();
    public String checkoutItem(String nameItem,int yearItem);
    public String checkinItem();
    public Object searchItem(String nameItem, int yearItem);

}
