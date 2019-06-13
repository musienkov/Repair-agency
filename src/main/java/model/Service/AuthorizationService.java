package model.Service;

import model.dao.DaoFactory;
import model.dao.UserDAO;
import model.entity.User;

public class AuthorizationService {

    public User getUserByLogin(String login) {
        User user = null;
        try {
            DaoFactory factory = DaoFactory.getInstance();
            UserDAO dao = factory.createUserDao();
            user = dao.findByLogin(login);

        } catch (Exception e) {

        }
        return user;
    }

    public boolean isExist(String login) {
        User user = null;
        try {
            DaoFactory factory = DaoFactory.getInstance();
            UserDAO dao = factory.createUserDao();
            user = dao.findByLogin(login);
        } catch (Exception e) {

        }
        if (user != null && user.getLogin().equals(login)) {
            return true;
        }
        return false;
    }

    public void registration(User user) {
        try{

            DaoFactory factory = DaoFactory.getInstance();

            UserDAO dao = factory.createUserDao();

            dao.create(user);
        } catch (Exception e) {

        }
    }
}