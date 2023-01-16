package org.example.library;

import org.example.library.api.UserRole;
import org.example.library.model.Role;
import org.example.library.model.User;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ApplicationContext {

    private static ActiveUser ACTIVE_USER;

    public static void setActiveUser(User user) {
        ACTIVE_USER = new ActiveUser(
                user.getLogin(),
                user.getName(),
                mapToUserRoles(user.getRoles())
        );
    }

    public static ActiveUser getActiveUser() {
        return ACTIVE_USER;
    }

    private static Set<UserRole> mapToUserRoles(List<Role> roles){
        return roles.stream().map(role -> UserRole.find(role.getName().toUpperCase()))
                .collect(Collectors.toSet());
    }

    //zwraca enuma USER z dużych liter, a gdyby w bazie było z małych user
}
