package controller.commands;

import controller.AuthUtility;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getSession().getAttribute("login").toString();

        AuthUtility.logout(request, login);

        return "redirect: /index";
    }
}
