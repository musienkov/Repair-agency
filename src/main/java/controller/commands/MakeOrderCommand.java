package controller.commands;

import model.Service.MasterService;

import javax.servlet.http.HttpServletRequest;

public class MakeOrderCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        long orderId = (Long) request.getSession().getAttribute("order_id");
        String info = request.getParameter("order_info");
        request.setAttribute("orderInfo", info);
        MasterService service = new MasterService();
        service.makeOrder(orderId);
        return "redirect: /master";
    }
}
