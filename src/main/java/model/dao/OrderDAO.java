package model.dao;

import model.entity.Order;

import java.util.List;

public interface OrderDAO extends GenericDAO<Order> {
    void acceptOrder(double price, long order_id, long master_id);
    void refuseOrder(long order_id, String reason);
    List<Order> findUnknownOrders();
    List<Order> findByMasterId(long master_id);
    List<Order> findOrderHistoryByMasterId(long master_id);
    List<Order> findCompletedOrdersByUserId(long user_id);
    List<Order> findRefusedOrdersByUserId(long user_id);
    List<Order> findAcceptedOrdersByUserId(long user_id);
    void makeOrder(long order_id);
    String findInfoByOrderId(long order_id);

}
