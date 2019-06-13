package controller.commands;

import model.Service.ManagerService;
import model.Service.UserService;
import model.entity.Order;
import model.entity.User;

import javax.servlet.http.HttpServletRequest;

public class AcceptOrderCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
       long masterId =Long.parseLong(request.getParameter("masterLogin"));
        String pr = request.getParameter("price");
        double price = Double.parseDouble(pr);

        long orderId = (Long) request.getSession().getAttribute("order_id");

        ManagerService service = new ManagerService();

        service.acceptOrder(price,orderId, masterId);

        return "redirect: /manager";
    }
}
