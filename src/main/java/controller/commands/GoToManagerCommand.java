package controller.commands;

import javax.servlet.http.HttpServletRequest;

public class GoToManagerCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/view/manager/manager.jsp";
    }
}
