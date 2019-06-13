package controller.commands;

import model.Service.MasterService;
import model.entity.Feedback;
import model.entity.Order;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GoToHistoryCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        long masterID = (long) request.getSession().getAttribute("id");
        MasterService service = new MasterService();
        List<Order> orderList = service.findOrderHistory(masterID);
        request.setAttribute("orderList", orderList);
        return "/WEB-INF/view/master/history.jsp";
    }
}
