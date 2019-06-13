package controller.commands;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class GoToUserCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {

        return "/WEB-INF/view/user/user.jsp";
    }
}
