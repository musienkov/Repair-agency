package controller.commands;

import model.Service.UserService;
import model.entity.Feedback;

import javax.servlet.http.HttpServletRequest;

public class LeaveFeedbackCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        long order_id = (Long) request.getSession().getAttribute("order_id");
        long userID = (long) request.getSession().getAttribute("id");
        String description = request.getParameter("description");
        Feedback feedback = new Feedback.Builder()
                .setCustomerId(userID)
                .setOrderId(order_id)
                .setDescription(description)
                .build();
        UserService service = new UserService();

        service.leaveFeedback(feedback);
        return "redirect: /user";
    }
}
