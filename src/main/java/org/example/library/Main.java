package org.example.library;

import org.example.library.model.User;

public class Main {
    public static void main(String[] args) {
        String testCheckstyle = "test";
        System.out.println(testCheckstyle);

        User user = new User(1, "login", "password", "name");
        user.getId();
    }
}
