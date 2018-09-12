package com.twu.utils;

import com.twu.library.Library;
import com.twu.utils.optionsMenu.OptionDefault;
import com.twu.utils.optionsMenu.OptionOne;
import com.twu.utils.optionsMenu.OptionThree;
import com.twu.utils.optionsMenu.OptionTwo;

public class SubMenu extends MenuAbstract {
    String message="";

    public SubMenu(int i, Library library){
        if(i==1){
            option = new OptionOne(library);
        }
        if(i==2){
            option = new OptionTwo(library);
        }
        if(i==3){
            option = new OptionThree();
        }
        if(i>3){
            option = new OptionDefault();
        }
    }

    @Override
    public String returnMessage(){
        option.resolve();
        return message;
    }
}
