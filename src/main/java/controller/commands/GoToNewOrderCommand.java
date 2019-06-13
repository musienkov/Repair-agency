package controller.commands;

import javax.servlet.http.HttpServletRequest;

public class GoToNewOrderCommand implements Command{

    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/view/user/create_order.jsp";
    }
}
