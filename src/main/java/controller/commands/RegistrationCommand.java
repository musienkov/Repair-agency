package controller.commands;

import model.Service.AuthorizationService;
import model.entity.User;

import javax.servlet.http.HttpServletRequest;

public class RegistrationCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {

        AuthorizationService service = new AuthorizationService();
        String name = request.getParameter("name");
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");
        String pass2 = request.getParameter("confirm");

        if (!pass.equals(pass2)) {

            return "redirect: /toregistr";
        }
        if(service.isExist(login)) {

            return "redirect: /toregistr";
        }


        User user = new User.Builder()
                .setName(name)
                .setLogin(login)
                .setPassword(pass)
                .setRole("USER")
                .build();

        service.registration(user);

        return "redirect: /index";
    }

}
