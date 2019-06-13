package model.dao;

import model.entity.Order;
import model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    private Connection connection;

    public OrderDAOImpl(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void create(Order entity) {
        final String query = "INSERT INTO orders (customer_id,product, info, status) values (?,?,?,?) ";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, entity.getCustomer_id());
            statement.setString(2,entity.getProduct());
            statement.setString(3,entity.getInfo());
            statement.setString(4,entity.getStatus().toString());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Order findById(int id) {
        return null;
    }

    @Override
    public List<Order> findAll() {
        List<Order> orderList = new ArrayList<>();
        final String query = "select id, customer_id, product, info, price, status, refusal_reason, master_id from orders";
        try{

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                long customer_id = resultSet.getLong("customer_id");
                String product = resultSet.getString("product");
                String info = resultSet.getString("info");

                Order order = new Order.Builder()
                        .setId(id)
                       .setCustomerId(customer_id)
                        .setProduct(product)
                        .setInfo(info)
                        .build();
                orderList.add(order);
            }


        } catch (SQLException e) {

            e.printStackTrace();
        }
        return orderList;
    }
    @Override
    public void acceptOrder(double price, long order_id, long master_id){
        final String query = "update orders set price = ?, status = ?, master_id = ? where id = ? ";
        try{

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setDouble(1, price);
            statement.setString(2,"ACCEPTED");
            statement.setLong(3, master_id);
            statement.setLong(4, order_id);
            statement.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    @Override
    public void makeOrder(long order_id){
        final String query = "update orders set status = ? where id = ? ";
        try{

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,"COMPLETED");
            statement.setLong(2, order_id);
            statement.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    @Override
    public String findInfoByOrderId(long order_id) {
        return null;
    }

    @Override
    public void refuseOrder(long order_id, String reason) {
        final String query = "update orders set refusal_reason = ?, status = ? where id = ? ";
        try{

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, reason);
            statement.setString(2,"REJECTED");
            statement.setLong(3, order_id);
            statement.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    @Override
    public List<Order> findUnknownOrders() {
        List<Order> orderList = new ArrayList<>();
        final String query = "select id, customer_id, product, info, price, status, refusal_reason, master_id from orders where status = 'UNKNOWN'";
        try{

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                long customer_id = resultSet.getLong("customer_id");
                String product = resultSet.getString("product");
                String info = resultSet.getString("info");

                String status = resultSet.getString("status");

                Order order = new Order.Builder()
                        .setId(id)
                        .setCustomerId(customer_id)
                        .setProduct(product)
                        .setInfo(info)
                        .setStatus(status)
                        .build();
                orderList.add(order);
            }


        } catch (SQLException e) {

            e.printStackTrace();
        }
        return orderList;
    }

    @Override
    public List<Order> findByMasterId(long master_id) {
        List<Order> orderList = new ArrayList<>();
        final String query = "select id, customer_id, product, info, price, status, refusal_reason, master_id from orders where status = ? AND master_id = ? ";
        try{

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "ACCEPTED");
            statement.setLong(2, master_id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                long customer_id = resultSet.getLong("customer_id");
                String product = resultSet.getString("product");
                String info = resultSet.getString("info");
                long price = resultSet.getLong("price");

                String status = resultSet.getString("status");

                Order order = new Order.Builder()
                        .setId(id)
                        .setCustomerId(customer_id)
                        .setProduct(product)
                        .setInfo(info)
                        .setPrice(price)
                        .setStatus(status)
                        .setMasterId(master_id)
                        .build();
                orderList.add(order);
            }


        } catch (SQLException e) {

            e.printStackTrace();
        }
        return orderList;
    }

    @Override
    public List<Order> findOrderHistoryByMasterId(long master_id) {
        List<Order> orderList = new ArrayList<>();
        final String query = "select id, customer_id, product, info, price, status, refusal_reason, master_id from orders where status = ? AND master_id = ? ";
        try{

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "COMPLETED");
            statement.setLong(2, master_id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String product = resultSet.getString("product");
                long price = resultSet.getLong("price");
                String status = resultSet.getString("status");

                Order order = new Order.Builder()
                        .setId(id)
                        .setProduct(product)
                        .setPrice(price)
                        .setStatus(status)
                        .setMasterId(master_id)
                        .build();
                orderList.add(order);
            }


        } catch (SQLException e) {

            e.printStackTrace();
        }
        return orderList;
    }

    @Override
    public List<Order> findCompletedOrdersByUserId(long user_id) {
        List<Order> orderList = new ArrayList<>();
        final String query = "select id, customer_id, product, info, price, status, refusal_reason, master_id from orders where status = 'COMPLETED' AND customer_id = ? ";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, user_id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                long customer_id = resultSet.getLong("customer_id");
                String product = resultSet.getString("product");
                String info = resultSet.getString("info");
                double price = resultSet.getDouble("price");
                String status = resultSet.getString("status");

                long master_id = resultSet.getLong("master_id");

                Order order = new Order.Builder()
                        .setId(id)
                        .setProduct(product)
                        .setInfo(info)
                        .setPrice(price)
                        .setStatus(status)
                        .setMasterId(master_id)
                        .build();
                orderList.add(order);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return orderList;
    }

    @Override
    public List<Order> findRefusedOrdersByUserId(long user_id) {
        List<Order> orderList = new ArrayList<>();
        final String query = "select id, customer_id, product, info, price, status, refusal_reason, master_id from orders where status = ? AND customer_id = ? ";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "REJECTED");
            statement.setLong(2, user_id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String product = resultSet.getString("product");
                String status = resultSet.getString("status");
                String reason = resultSet.getString("refusal_reason");


                Order order = new Order.Builder()
                        .setId(id)
                        .setProduct(product)
                        .setStatus(status)
                        .setRefusalReason(reason)
                        .build();
                orderList.add(order);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return orderList;
    }

    @Override
    public List<Order> findAcceptedOrdersByUserId(long user_id) {
        List<Order> orderList = new ArrayList<>();
        final String query = "select id, customer_id, product, info, price, status, refusal_reason, master_id from orders where status = ? AND customer_id = ? ";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "ACCEPTED");
            statement.setLong(2, user_id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String product = resultSet.getString("product");
                String status = resultSet.getString("status");
                double price = resultSet.getDouble("price");


                Order order = new Order.Builder()
                        .setId(id)
                        .setProduct(product)
                        .setStatus(status)
                        .setPrice(price)
                        .build();
                orderList.add(order);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return orderList;
    }


    @Override
    public void update(Order entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() {

    }
}
