package com.twu.library.libraries;

import com.twu.library.Items;
import com.twu.login.Login;
import com.twu.user.User;
import com.twu.utils.Dictionary;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LibraryTest {
    public Library library;
    Dictionary dictionary;
    public Login login;
    private User user;

    @Mock
    ItemLibrary itemLibraryMock;

    @InjectMocks
    Library libraryMock;


    @Before
    public void setUp() {
        user = new User();
        login = new Login(user.createUsers());
        library = new Library(new BookLibrary(), login);
    }

    @Test
    public void shouldShowWelcomeMessageWhenIniatilizingObjectLibrary() {
        assertEquals(dictionary.MESSAGE_WELCOME_TO_LIBRARY, new Library(new BookLibrary(), login).showWelcomeMessage());
    }


    @Test
    public void shouldReturnDataOfLastBookOfTheListOfBooksWhenSendAList() {
        String informationBook = "Divergent \t| Veronica Roth \t| 2012";

        assertEquals(informationBook, library.showListItem());
    }

    @Test
    public void shouldReturnSuccessfulMessageWhenCheckoutHappen() {
        String messageExpected = "Thank you! Enjoy the item";
        String nameBook = "Harry Potter";
        login.compareCredentials("123-1236", "passwd1");

        assertEquals(messageExpected, library.checkoutItem(nameBook));
    }

    @Test
    public void shouldReturnUnsuccessfulMessageWhenErrorInCheckout() {
        String messageExpected = "That item is not available";

        assertEquals(messageExpected, library.checkoutItem("Test Driven Development"));
    }

    @Test
    public void shouldReturnSuccessfulMessageWhenTheBookIsReturned() {
        String nameBook = "Harry Potter";
        login.compareCredentials("123-1236", "passwd1");

        library.checkoutItem(nameBook);

        library.searchIteminLibrary(nameBook);

        assertEquals("Thank you for returning the item", library.checkinItem());

    }

    @Test
    public void shouldReturnUnsuccessfulMessageWhenErrorInReturn() {
        String nameBook = "Test Driven Development: By Example";


        library.searchIteminLibrary(nameBook);

        assertEquals("That is not a valid item to return", library.checkinItem());
    }

    @Test
    public void shouldReturnNameOfBookWhenItIsSearch() {
        Object bookSearchedInLibrary = library.searchIteminLibrary("Harry Potter");
        Object bookSearchedNotInLibrary = library.searchIteminLibrary("Hello Book");

        assertThat(bookSearchedInLibrary, is(notNullValue()));
        assertThat(bookSearchedNotInLibrary, is(notNullValue()));

    }

    @Test
    public void shouldReturnEmptyWhenListOfItemsRegisteredHasNoElements() {
        List<Items> itemsRegistered = library.getCurrentList();

        assertThat(itemsRegistered, is(empty()));
    }

    @Test
    public void shouldReturnNotEmptyWhenListOfItemsRegisteredHasElements() {
        String nameItem="Harry Potter";

        library.checkoutItem(nameItem);

        List<Items> itemsRegistered = library.getCurrentList();

        assertThat(itemsRegistered, is(not(empty())));
    }

    @Test
    public void shouldVerifyIfMethodOfShowListItemOfItemLibraryItIsBeenCalled(){
        int numberInvocations=1;

        libraryMock=new Library(itemLibraryMock,login);
        libraryMock.showListItem();
        verify(itemLibraryMock,times(numberInvocations)).showListItem();
    }

    @Test
    public void shouldVerifyIfMethodSearchItemOfItemLibraryItIsBeenCalled(){
        int numberInvocations=1;

        libraryMock=new Library(itemLibraryMock,login);
        libraryMock.searchIteminLibrary("Harry Potter");
        verify(itemLibraryMock,times(numberInvocations)).searchItem("Harry Potter");
    }

    @Test
    public void shouldVerifyIfMethodCheckInOfItemLibraryItIsBeenCalled(){
        int numberInvocations=1;

        libraryMock= new Library(itemLibraryMock,login);
        libraryMock.checkinItem();
        verify(itemLibraryMock,times(numberInvocations)).checkinItem();


    }

}
