package controller.commands;

import model.Service.ManagerService;

import javax.servlet.http.HttpServletRequest;

public class RefuseOrderCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String reason = request.getParameter("reason");

        long orderId = (Long) request.getSession().getAttribute("orderId");

        ManagerService service = new ManagerService();

        service.refuseOrder(orderId, reason);

        return "redirect: /manager";
    }
}
