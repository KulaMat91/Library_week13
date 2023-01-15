package org.example.library.service;

import org.example.library.api.UserLoginData;
import org.example.library.model.User;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class UserServiceTest {

    private final User existingUser = new User(1, "login", "password", "name", null, null);
    private final UserService userService = new UserService(
            login -> Optional.of(new User(1, "login", "password", "name",null ,null)));

    @Test
    void userPasswordAndProvidedPasswordAreTheSameReturnSelectedUser() {
        //given
        UserLoginData userLoginData = new UserLoginData("login", "password");
        //when
        Optional<User> result = userService.checkAndGet(userLoginData);
        //then
        assertThat(result.get()).isEqualTo(existingUser);
    }

    @Test
    void userPasswordAndProvidedPasswordAreDifferentReturnOptionalEmpty() {
        //given
        UserLoginData userLoginData = new UserLoginData("login", "incorrectPassword");
        //when
        Optional<User> result = userService.checkAndGet(userLoginData);
        //then
        assertThat(result).isEmpty();

    }

    @Test
    void whenUserLoginDoesNotExistReturnOptionalEmpty() {
        //given
        UserLoginData userLoginData = new UserLoginData("login", "incorrectPassword");
        //when
        Optional<User> result = userService.checkAndGet(userLoginData);
        //then
    }

}