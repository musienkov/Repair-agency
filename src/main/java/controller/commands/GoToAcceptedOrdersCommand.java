package controller.commands;

import model.Service.UserService;
import model.entity.Order;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GoToAcceptedOrdersCommand implements Command {

        @Override
        public String execute(HttpServletRequest request) {
            long userID = (long) request.getSession().getAttribute("id");
            UserService service = new UserService();
            List<Order> orderList = service.getAcceptedOrders(userID);

            request.setAttribute("orderList", orderList);
            return "/WEB-INF/view/user/accepted_orders.jsp";
        }

}
