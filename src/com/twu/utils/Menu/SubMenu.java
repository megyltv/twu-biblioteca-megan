package com.twu.utils.Menu;

import com.twu.library.libraries.Library;
import com.twu.utils.Menu.optionsMenu.OptionDefault;
import com.twu.utils.Menu.optionsMenu.OptionOne;
import com.twu.utils.Menu.optionsMenu.OptionThree;
import com.twu.utils.Menu.optionsMenu.OptionTwo;

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
