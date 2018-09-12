package com.twu.login;

public class User {
    private String idLibraryCode;
    private String password;
    private String nameUser;
    private String emailAdress;
    private String phoneNumber;

    public User(String idLibraryCode, String password, String nameUser, String emailAdress, String phoneNumber) {
        this.idLibraryCode = idLibraryCode;
        this.password = password;
        this.nameUser = nameUser;
        this.emailAdress = emailAdress;
        this.phoneNumber = phoneNumber;
    }

    public void printUserInformation() {
        System.out.println("ID Library Code: " + this.idLibraryCode);
        System.out.println("Name: " + this.nameUser);
        System.out.println("Email Adress: " + this.emailAdress);
        System.out.println("Phone Number: " + this.phoneNumber);
    }

    public String getPassword() {
        return password;
    }

    public String getIdLibraryCode() {
        return idLibraryCode;
    }
}
