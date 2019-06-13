package model.Service;

import model.dao.DaoFactory;
import model.dao.OrderDAO;
import model.dao.UserDAO;
import model.entity.Order;
import model.entity.User;

import java.util.ArrayList;
import java.util.List;

public class ManagerService {

    public void acceptOrder(double price, long order_id, long master_id){

        try {
            DaoFactory factory = DaoFactory.getInstance();
            OrderDAO dao = factory.createOrderDao();
            dao.acceptOrder(price,order_id, master_id);


        } catch (Exception e) {


        }

    }

    public void refuseOrder(long order_id, String reason){

        try {

            DaoFactory factory = DaoFactory.getInstance();
            OrderDAO dao = factory.createOrderDao();
            dao.refuseOrder(order_id, reason);


        } catch (Exception e) {


        }

    }


    public List<User> findAllMasters(){
        List<User> masterList = new ArrayList<>();
        try {


            DaoFactory factory = DaoFactory.getInstance();
            UserDAO dao = factory.createUserDao();
            masterList = dao.findAllMasters();

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return masterList;
    }


}
