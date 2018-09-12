package com.twu.utils;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PrinterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    public void shouldReturnMenuShowedInConsoleWhenTheMenuIsGenerated() {
        PrinterReader printerReader = new PrinterReader();
        printerReader.printMenuOptions();

        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldReturnSubMenuInConsoleWhenTheSubmenuIsGenerated() {
        PrinterReader printerReader = new PrinterReader();
        printerReader.printSubMenuOptions();

        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldReturnMessageWhenItIsSendToMethod() {
        String messageSend = "Test";

        PrinterReader printerReader = new PrinterReader();
        printerReader.printMessageReceived("messageSend");

        System.setOut(new PrintStream(outContent));


    }


}