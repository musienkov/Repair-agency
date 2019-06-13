package model.Service;

import model.dao.DaoFactory;
import model.dao.OrderDAO;
import model.entity.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    public List<Order> findAllOrders(){
        List<Order> orderList = new ArrayList<>();
        try {
            DaoFactory factory = DaoFactory.getInstance();
            OrderDAO dao = factory.createOrderDao();
            orderList = dao.findAll();

        } catch (Exception e) {

        }
        return orderList;
    }


    public List<Order> findUnknownOrders(){
        List<Order> orderList = new ArrayList<>();
        try {
            DaoFactory factory = DaoFactory.getInstance();
            OrderDAO dao = factory.createOrderDao();
            orderList = dao.findUnknownOrders();
            for (Order order:orderList
            ) {

            }
        } catch (Exception e) {


        }
        return orderList;
    }

    public List<Order> findByMasterId(long master_id){
        List<Order> orderList = new ArrayList<>();
        try {
            DaoFactory factory = DaoFactory.getInstance();
            OrderDAO dao = factory.createOrderDao();
            orderList = dao.findByMasterId(master_id);

        } catch (Exception e) {


        }
        return orderList;
    }

}
