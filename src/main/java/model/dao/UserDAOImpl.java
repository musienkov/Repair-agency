package model.dao;

import model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private Connection connection;

    public UserDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(User user) {
        final String query = " insert into users (name, login, password, role) values (?, ?, ?, ?) ";
        try{



            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getName());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getRole().toString().toLowerCase());



        } catch (SQLException e) {


            e.printStackTrace();
        }
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() {

    }

    @Override
    public User findByLogin(String login) {
        User user = null;
        final String query = " select * from users where users.login = ?";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String userLogin = resultSet.getString("login");
                String password = resultSet.getString("password");
                String role = resultSet.getString("role");

                user = new User.Builder()
                        .setId(id)
                        .setLogin(userLogin)
                        .setName(name)
                        .setRole(role)
                        .setPassword(password)
                        .build();
            }
            else {
                //wrong login/password
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> findAllMasters() {
        List<User> masterList = new ArrayList<>();
        final String query = "select id, name, login, password, role from users where role = 'master' ";
        try{
            System.out.println("попали в трай в мастер дао імпл");
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name  = resultSet.getString("name");
                String userLogin = resultSet.getString("login");
                String password = resultSet.getString("password");
                String role = resultSet.getString("role");

                User user = new User.Builder()
                        .setId(id)
                        .setLogin(userLogin)
                        .setName(name)
                        .setRole(role)
                        .setPassword(password)
                        .build();
                masterList.add(user);
            }


        } catch (SQLException e) {

            e.printStackTrace();
        }
        return masterList;
    }
}
