package com.twu.library.libraries;

import java.util.List;

public interface ItemLibrary {
    public String showListItem();
    public String checkoutItem(String nameItem);
    public String checkinItem();
    public Object searchItem(String nameItem);

}
