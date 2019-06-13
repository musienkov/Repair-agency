package controller.commands;

import model.Service.UserService;
import model.entity.Order;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GoToRefusedOrdersCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        long userID = (long) request.getSession().getAttribute("id");
        UserService service = new UserService();
        List<Order> orderList = service.getRefusedOrders(userID);

        request.setAttribute("orderList", orderList);
        return "/WEB-INF/view/user/refused_orders.jsp";
    }
}
