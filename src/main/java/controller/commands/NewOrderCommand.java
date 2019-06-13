package controller.commands;

import model.Service.UserService;
import model.entity.Order;

import javax.servlet.http.HttpServletRequest;

public class NewOrderCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        long userID = (long) request.getSession().getAttribute("id");
        String name = request.getParameter("productname");
        String info = request.getParameter("info");

        Order order = new Order.Builder()
                .setCustomerId(userID)
                .setProduct(name)
                .setInfo(info)
                .setStatus("UNKNOWN")
                .build();

        UserService service = new UserService();
        service.newOrder(order);
        return "redirect: /user";
    }
}
