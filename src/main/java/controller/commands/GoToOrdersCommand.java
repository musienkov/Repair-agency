package controller.commands;

import model.Service.OrderService;
import model.entity.Order;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GoToOrdersCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        long managerID = (long) request.getSession().getAttribute("id");
        OrderService service = new OrderService();
        List<Order> orderList = service.findByMasterId(managerID);
        request.setAttribute("orderList", orderList);
         return "/WEB-INF/view/master/orders.jsp";
    }
}
