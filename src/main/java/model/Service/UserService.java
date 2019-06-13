package model.Service;

import model.dao.DaoFactory;
import model.dao.FeedbackDAO;
import model.dao.OrderDAO;
import model.dao.UserDAO;
import model.entity.Feedback;
import model.entity.Order;
import model.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    public void newOrder(Order order) {
        try{
            DaoFactory factory = DaoFactory.getInstance();
            OrderDAO dao = factory.createOrderDao();
            dao.create(order);
        } catch (Exception e) {

        }

    }
    public List<Order> getCompletedOrders(long user_id){
    List<Order> orderList = new ArrayList<>();
        try{
            DaoFactory factory = DaoFactory.getInstance();
            OrderDAO dao = factory.createOrderDao();
            orderList = dao.findCompletedOrdersByUserId(user_id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return orderList;
    }

    public List<Order> getRefusedOrders(long user_id){
        List<Order> orderList = new ArrayList<>();
        try{
            DaoFactory factory = DaoFactory.getInstance();
            OrderDAO dao = factory.createOrderDao();
            orderList = dao.findRefusedOrdersByUserId(user_id);
        } catch (Exception e) {

        }
        return orderList;
    }
    public List<Order> getAcceptedOrders(long user_id){
        List<Order> orderList = new ArrayList<>();
        try{
            DaoFactory factory = DaoFactory.getInstance();
            OrderDAO dao = factory.createOrderDao();
            orderList = dao.findAcceptedOrdersByUserId(user_id);
        } catch (Exception e) {

        }
        return orderList;
    }

    public void leaveFeedback(Feedback feedback){
        try{
            DaoFactory factory = DaoFactory.getInstance();
            FeedbackDAO dao = factory.createFeedbackDao();
            dao.create(feedback);
        } catch (Exception e) {

        }

    }

}
