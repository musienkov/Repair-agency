package controller.commands;

import javax.servlet.http.HttpServletRequest;

public class GoToMasterCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/view/master/master.jsp";
    }
}
