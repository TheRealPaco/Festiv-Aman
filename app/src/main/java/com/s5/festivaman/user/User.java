package com.s5.festivaman.user;

public class User {

    private static boolean isLoggedIn = false;
    private static String userName;

    public static String getUserName() {
        return userName;
    }

    public static void logIn(String name) {
        isLoggedIn = true;
        userName = name;
    }

    public static void logOut() {
        isLoggedIn = true;
        userName =  null;
    }
}
