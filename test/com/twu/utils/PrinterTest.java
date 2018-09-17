package com.twu.utils;

import com.twu.library.Items;
import com.twu.user.User;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PrinterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    public void shouldReturnMenuShowedInConsoleWhenTheMenuIsGenerated() {
        PrinterReader printerReader = new PrinterReader();
        printerReader.printMenuOptionsCustomer();

        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldReturnSubMenuInConsoleWhenTheSubmenuIsGenerated() {
        PrinterReader printerReader = new PrinterReader();
        printerReader.printSubMenuOptions("Book");

        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldReturnMessageWhenItIsSendToMethod() {
        String messageSend = "Test";

        PrinterReader printerReader = new PrinterReader();
        printerReader.printMessageReceived(messageSend);

        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldReturnItemsWhenTheMethodIsCalled() {
        User user=new User("123-1234","pass","Ell","el@ej.com","29384756", User.Role.CUSTOMER);
        Items itemsRegistered = new Items(user,"Harry Potter");


        PrinterReader printerReader = new PrinterReader();
        printerReader.printItemsRegistered(itemsRegistered);

        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldReturnTitlesOfItemsRegistered(){
        PrinterReader printerReader = new PrinterReader();
        printerReader.printItemsRegisteredTitles();

        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldReturnInformationOfUserPrintedWhenTheMethodIsCalled() {
        PrinterReader printerReader = new PrinterReader();
        User user=new User("123-1234","pass","Ell","el@ej.com","29384756", User.Role.CUSTOMER);
        printerReader.printUserInformation(user);

        System.setOut(new PrintStream(outContent));
    }

}