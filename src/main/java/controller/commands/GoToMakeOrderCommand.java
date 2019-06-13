package controller.commands;

import model.Service.ManagerService;
import model.Service.MasterService;
import model.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class GoToMakeOrderCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        long order_id = Long.parseLong(request.getParameter("order_id")) ;
        String info = request.getParameter("order_info");
        request.setAttribute("order_id", order_id);
        request.setAttribute("order_info", info);

        request.getSession().setAttribute("order_id", order_id);

        return "/WEB-INF/view/master/make_order.jsp";

    }
}
