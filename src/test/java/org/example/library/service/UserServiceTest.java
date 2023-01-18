package org.example.library.service;

import org.example.library.api.UserLoginData;
import org.example.library.dao.UserProvider;
import org.example.library.model.User;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class UserServiceTest {

    private final static User EXISTING_USER = new User(1, "existingLogin", "password", "name", "email", null, null);

    //    private final UserService userService = new UserService(
    //            login -> Optional.of(EXISTING_USER)
    //    );

    //    private final UserService userService = new UserService(new LocalUserProvider());


    private final UserService userService = new UserService(
            login -> {
                if (login.equals("existingLogin")) {
                    return Optional.of(EXISTING_USER);
                } else {
                    return Optional.empty();
                }
            }
    );

    @Test
    void userPasswordAndProvidedPasswordAreTheSameReturnSelectedUser() {
        //given
        UserLoginData userLoginData = new UserLoginData("existingLogin", "password");
        //when
        Optional<User> result = userService.checkAndGet(userLoginData);
        //then
        assertThat(result.get()).isEqualTo(EXISTING_USER);
    }

    @Test
    void userPasswordAndProvidedPasswordAreDifferentReturnOptionalEmpty() {
        //given
        UserLoginData userLoginData = new UserLoginData("existingLogin", "incorrectPassword");
        //when
        Optional<User> result = userService.checkAndGet(userLoginData);
        //then
        assertThat(result).isEmpty();

    }

    @Test
    void whenUserLoginDoesNotExistReturnOptionalEmpty() {
        UserService userService = new UserService(
                login -> Optional.empty()
        );
        //given
        UserLoginData userLoginData = new UserLoginData("login", "password");
        //when
        Optional<User> result = userService.checkAndGet(userLoginData);
        //then
        assertThat(result).isEmpty();
    }

    private static class LocalUserProvider implements UserProvider {
        @Override
        public Optional<User> findUserByLogin(String login) {
            if (login.equals("existingLogin")) {
                return Optional.of(EXISTING_USER);
            }
            return Optional.empty();
        }
    }

}