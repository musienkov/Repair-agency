package controller.commands;

import controller.AuthUtility;
import model.Service.AuthorizationService;
import model.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

public class LoginCommand implements Command {


    @Override
    public String execute(HttpServletRequest request) {

        AuthorizationService service = new AuthorizationService();
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");


        if(login == null || login.equals("") || pass == null || pass.equals("")) {

            request.setAttribute("error", "Empty login or password");
            return "/index.jsp";
        }

        User user = service.getUserByLogin(login);

        if(AuthUtility.isLogged(request, login)) {

            request.setAttribute("error", "User already logged");
            return "/index.jsp";
        }


        if(!Objects.isNull(user) && user.getPassword().equals(pass)) {
            String redirectPath = AuthUtility.login(request, user).toLowerCase();
            return "redirect: /" + redirectPath;
        }
        else {

            request.setAttribute("error", "Wrong login/password");
            return "/index.jsp";
        }
    }
}
