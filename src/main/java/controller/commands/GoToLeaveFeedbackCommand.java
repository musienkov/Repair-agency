package controller.commands;

import model.entity.Feedback;

import javax.servlet.http.HttpServletRequest;

public class GoToLeaveFeedbackCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        long order_id = Long.parseLong(request.getParameter("order_id")) ;
        long userID = (long) request.getSession().getAttribute("id");
        request.setAttribute("order_id", order_id);
        request.setAttribute("user_id", userID);
        request.getSession().setAttribute("order_id", order_id);


        return "/WEB-INF/view/user/leave_feedback.jsp";
    }
}
