package model.dao;

import model.dao.*;
import model.dao.DaoFactoryJDBC;

public abstract class DaoFactory {

    private static DaoFactory daoFactory;


    public abstract UserDAO createUserDao();
    public abstract OrderDAO createOrderDao();
    public abstract FeedbackDAO createFeedbackDao();


    public static DaoFactory getInstance() {
        if(daoFactory == null) {
            synchronized (DaoFactory.class) {
                if(daoFactory == null) {
                    DaoFactory temp = new DaoFactoryJDBC();
                    daoFactory = temp;
                }
            }
        }
        return daoFactory;
    }

}
