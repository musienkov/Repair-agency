package model.Service;

import model.dao.DaoFactory;
import model.dao.FeedbackDAO;
import model.dao.OrderDAO;
import model.entity.Feedback;
import model.entity.Order;

import java.util.ArrayList;
import java.util.List;

public class MasterService {

    public void makeOrder(long order_id){

        try {
            DaoFactory factory = DaoFactory.getInstance();
            OrderDAO dao = factory.createOrderDao();
            dao.makeOrder(order_id);


        } catch (Exception e) {


        }

    }

    public List<Feedback> findAllFeedbackByMasterId(long master_id){
        List<Feedback> feedbackList = new ArrayList<>();
        try {
            DaoFactory factory = DaoFactory.getInstance();
            FeedbackDAO dao = factory.createFeedbackDao();
            feedbackList = dao.findAllFeedbackByMasterId(master_id);


        } catch (Exception e) {


        }
        return feedbackList;
    }
    public List<Order> findOrderHistory(long master_id){
        List<Order> orderList = new ArrayList<>();
        try {
            DaoFactory factory = DaoFactory.getInstance();
            OrderDAO dao = factory.createOrderDao();
            orderList = dao.findOrderHistoryByMasterId(master_id);


        } catch (Exception e) {


        }
        return orderList;
    }
}
