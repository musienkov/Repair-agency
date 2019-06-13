package controller.commands;

import model.Service.MasterService;
import model.entity.Feedback;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GoToFeedbackCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        long masterID = (long) request.getSession().getAttribute("id");
        MasterService service = new MasterService();
        List<Feedback> feedbackList = service.findAllFeedbackByMasterId(masterID);
        request.setAttribute("feedbackList", feedbackList);
        return "/WEB-INF/view/master/feedback.jsp";
    }
}
