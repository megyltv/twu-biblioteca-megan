package com.twu.login;

import com.twu.user.User;
import com.twu.utils.Dictionary;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class LoginTest {
    Login login;
    User user;
    List<User> userList;
    Dictionary dictionary;

    @Before
    public void setUp(){
        login=new Login(new User().createUsers());
        user = new User("123-1234", "passwd", "Mary", "mar@ej.com", "20983950", User.Role.CUSTOMER);

        userList=new ArrayList<User>();
        userList.add(new User("123-1235", "passwd", "Mary", "mar@ej.com", "20983950", User.Role.CUSTOMER));
        userList.add(new User("123-1236", "passwd1", "John", "john@ej.com", "20983951", User.Role.CUSTOMER));
        userList.add(new User("123-1237", "passwd2", "Anna", "anna@ej.com", "20983952", User.Role.LIBRARIAN));
    }

    @Test
    public void shouldReturnTrueWhenUserIsCorrect(){
        String idLibraryReceived="123-1234";

        assertTrue(login.compareUser(idLibraryReceived,user));
    }

    @Test
    public void shouldReturnFalseWhenUserIsIncorrect(){
        String idLibraryReceived="123-1233";

        assertFalse(login.compareUser(idLibraryReceived,user));
    }

    @Test
    public void shouldReturnTrueWhenUserAndPasswordIsCorrect(){

        String idLibraryCodeReceived="123-1235";
        String passwordReceived="passwd";

        assertTrue(login.compareCredentials(idLibraryCodeReceived,passwordReceived));
    }

    @Test
    public void shouldReturnFalseWhenUserOrPasswordIsIncorrect(){
        String idLibraryCodeReceived = "123-1254";
        String passwordReceived = "passwd";

        assertFalse(login.compareCredentials(idLibraryCodeReceived, passwordReceived));

        idLibraryCodeReceived = "123-1235";
        passwordReceived = "1234";

        assertFalse(login.compareCredentials(idLibraryCodeReceived, passwordReceived));

    }

    @Test
    public void shouldReturnFalseWhenUserAndPasswordAreIncorrect(){
        String idLibraryCodeReceived = "123-1298";
        String passwordReceived = "12345678";

        assertFalse(login.compareCredentials(idLibraryCodeReceived, passwordReceived));
    }

    @Test
    public void shouldReturnMessageWhenValuesAreIncorrect(){
        String messageExpected=dictionary.MESSAGE_LOGIN_INCORRECT;
        boolean received = false;

        assertEquals(messageExpected,login.showMessageIfIncorrect(received));
    }

    @Test
    public void shouldReturnNotNullIfUserIsSet(){
        String idLibraryCodeReceived="123-1235";
        String passwordReceived="passwd";

        login.compareCredentials(idLibraryCodeReceived,passwordReceived);

        User userLoggedIn=login.getCurrentUser();

        assertThat(userLoggedIn,is(notNullValue()));
    }

    @Test
    public void shouldReturnNullIfUserLoggedOut(){
        String idLibraryCodeReceived="123-1235";
        String passwordReceived="passwd";

        login.compareCredentials(idLibraryCodeReceived,passwordReceived);
        login.logOut();
        User userLoggedOut=login.getCurrentUser();

        assertThat(userLoggedOut,is(nullValue()));

    }



}