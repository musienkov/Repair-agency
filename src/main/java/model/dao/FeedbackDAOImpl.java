package model.dao;

import model.entity.Feedback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDAOImpl implements FeedbackDAO {

    private Connection connection;


    public FeedbackDAOImpl(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void create(Feedback feedback) {
        final String query = " insert into feedback (customer_id, order_id, description) values (?, ?, ?) ";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, feedback.getCustomerId());
            statement.setLong(2, feedback.getOrder_id());
            statement.setString(3, feedback.getDescription());
            statement.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    @Override
    public Feedback findById(int id) {
        return null;
    }

    @Override
    public List<Feedback> findAll() {
       return null;
    }

    @Override
    public void update(Feedback entity) {

    }

    @Override
    public void delete(int id) {

    }


    @Override
    public List<Feedback> findAllFeedbackByMasterId(long master_id) {
        List<Feedback> feedbackList = new ArrayList<>();
        final String query = "select feedback.id, feedback.customer_id, feedback.order_id, feedback.description from feedback " +
                " inner join orders on feedback.order_id = orders.id where orders.master_id = ? ";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, master_id);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                long customer_id = resultSet.getLong("customer_id");
                long order_id = resultSet.getLong("order_id");
                String description = resultSet.getString("description");

                Feedback feedback = new Feedback.Builder()
                        .setId(id)
                        .setCustomerId(customer_id)
                        .setOrderId(order_id)
                        .setDescription(description)
                        .build();

                feedbackList.add(feedback);

            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return feedbackList;
    }

    @Override
    public void close() {

    }
}
