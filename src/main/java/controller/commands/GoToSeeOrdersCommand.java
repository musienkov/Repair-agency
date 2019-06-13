package controller.commands;

import model.Service.OrderService;
import model.entity.Order;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GoToSeeOrdersCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {


        OrderService service = new OrderService();
        List<Order> orderList = service.findUnknownOrders();
        request.setAttribute("orderList", orderList);

        return "/WEB-INF/view/manager/see_orders.jsp";
    }
}
