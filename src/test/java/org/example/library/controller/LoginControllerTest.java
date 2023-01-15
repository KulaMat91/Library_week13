package org.example.library.controller;

import org.example.library.api.UserLoginData;
import org.example.library.model.User;
import org.example.library.service.UserService;
import org.example.library.view.MainMenuView;
import org.example.library.view.View;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LoginControllerTest {

    LoginController loginController = new LoginController(
            new UserService(
                    login -> Optional.of(new User(1, "login","password", "name", null, null))
            )
    );
    @Test
    void shouldReturnMainMenuViewWhenUserISPresent() {
        View view = loginController.login(new UserLoginData("login", "password"));
        assertThat(result).isInstanceOf(MainMenuView.class);

    }

    @Test
    void shouldReturnLoginViewWhenUserLoginDataIsIncorrect() {

    }

}