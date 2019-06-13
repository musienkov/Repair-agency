package model.dao;

import model.dao.*;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DaoFactoryJDBC extends DaoFactory {



    private DataSource dataSource = ConnectingJDBC.getDataSource();

    private Connection getConnection() {
        try{

            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public UserDAO createUserDao() {
        return new UserDAOImpl(getConnection());
    }

    @Override
    public OrderDAO createOrderDao() {
        return new OrderDAOImpl(getConnection());
    }

    @Override
    public FeedbackDAO createFeedbackDao() {
        return new FeedbackDAOImpl(getConnection());
    }
}
