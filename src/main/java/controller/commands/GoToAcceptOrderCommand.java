package controller.commands;

import model.Service.ManagerService;
import model.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class GoToAcceptOrderCommand implements Command{

    @Override
    public String execute(HttpServletRequest request) {


        long order_id = Long.parseLong(request.getParameter("order_id")) ;

        request.setAttribute("order_id", order_id);

        request.getSession().setAttribute("order_id", order_id);
        List<User> masterList = new ArrayList<>();
        ManagerService service = new ManagerService();
        masterList = service.findAllMasters();
        request.setAttribute("masterList", masterList);

        return "/WEB-INF/view/manager/accept_order.jsp";
    }
}
