package model.dao;

import model.entity.User;

import java.util.List;

public interface UserDAO extends GenericDAO<User> {
    User findByLogin(String login);
    List<User> findAllMasters();
}
