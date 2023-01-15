package org.example.library.dao;

import org.example.library.model.User;
import org.example.library.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Optional;

public class UserDao implements UserProvider{
private final static String SEARCH_BY_LOGIN_QUERY = "from User u where u.login=:login";
    @Override
    public Optional<User> findUserByLogin(String login) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<User> query = session.createQuery(SEARCH_BY_LOGIN_QUERY, User.class).setParameter("login",login);
        return Optional.empty();
    }
}
