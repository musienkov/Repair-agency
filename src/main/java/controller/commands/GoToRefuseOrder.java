package controller.commands;

import model.Service.ManagerService;
import model.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class GoToRefuseOrder implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        long order_id = Long.parseLong(request.getParameter("orderId")) ;

        request.setAttribute("orderId", order_id);

        request.getSession().setAttribute("orderId", order_id);

        return "/WEB-INF/view/manager/refuse_order.jsp";
    }
}
