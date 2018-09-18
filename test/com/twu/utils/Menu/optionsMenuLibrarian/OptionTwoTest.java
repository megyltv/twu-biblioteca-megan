package com.twu.utils.Menu.optionsMenuLibrarian;

import com.twu.login.Login;
import com.twu.user.User;
import com.twu.utils.Dictionary;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class OptionTwoTest {
    private Login login;
    private Dictionary dictionary;
    private OptionTwo optionTwo;

    @Mock
    Login loginMock;
    User userMock;

    @InjectMocks
    OptionTwo optionTwoMock;

    @Before
    public void setUp() throws Exception {
        User user = new User();
        login = new Login(user.createUsers());

        login.compareCredentials("123-1236","passwd1");

        optionTwo=new OptionTwo(login);
    }

    @Test
    public void shouldReturnMessageOfQuitWhenSelectedOptionOfLogOut(){
        String messageExpected=dictionary.MESSAGE_QUIT;
        String messageReceived=optionTwo.resolve();

        assertEquals(messageExpected,messageReceived);
    }

    @Test
    public void shouldVerifyIfMethodLogOutItIsBeenCalledWithinTheMethod(){
        int numberInvocations=1;
        userMock = new User();
        loginMock = Mockito.spy(new Login(userMock.createUsers()));

        loginMock.compareCredentials("123-1236","passwd1");
        optionTwoMock=new OptionTwo(loginMock);

        optionTwoMock.resolve();
        verify(loginMock,times(numberInvocations)).logOut();
    }


}