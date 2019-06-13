package controller;
import controller.commands.*;
import model.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
public class Servlet extends HttpServlet {
    private Map<String, Command> commandMap = new HashMap<>();

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

        User user = new User.Builder()
                .setRole(User.ROLE.UNKNOWN.toString())
                .build();
        servletConfig.getServletContext().setAttribute("loggedUsers", new HashSet<String>());


        commandMap.put("/toregistr", new GoToRegistrationCommand());
        commandMap.put("/registration", new RegistrationCommand());
        commandMap.put("/index", new GoToIndexCommand());
        commandMap.put("/user", new GoToUserCommand());
        commandMap.put("/manager", new GoToManagerCommand());
        commandMap.put("/master", new GoToMasterCommand());
        commandMap.put("/login", new LoginCommand());
        commandMap.put("/logout", new LogoutCommand());
        commandMap.put("/neworder", new NewOrderCommand());
        commandMap.put("/gotoneworder", new GoToNewOrderCommand());
        commandMap.put("/gotoseeorders", new GoToSeeOrdersCommand());
        commandMap.put("/acceptorder", new AcceptOrderCommand());
        commandMap.put("/gotoacceptorder", new GoToAcceptOrderCommand());
        commandMap.put("/gotoorders", new GoToOrdersCommand());

        commandMap.put("/gotorefuseorder", new GoToRefuseOrder());
        commandMap.put("/refuseorder", new RefuseOrderCommand());
        commandMap.put("/gotomakeorder", new GoToMakeOrderCommand());
        commandMap.put("/makeorder", new MakeOrderCommand());
        commandMap.put("/gotocompletedorders", new GoToCompletedOrders());
        commandMap.put("/gotorefusedorders", new GoToRefusedOrdersCommand());
        commandMap.put("/gotoacceptedorders", new GoToAcceptedOrdersCommand());
        commandMap.put("/gotoleavefeedback", new GoToLeaveFeedbackCommand());
        commandMap.put("/leavefeedback", new LeaveFeedbackCommand());
        commandMap.put("/gotofeedback", new GoToFeedbackCommand());
        commandMap.put("/gotohistory", new GoToHistoryCommand());

    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        processRequest(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        processRequest(httpServletRequest, httpServletResponse);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String path = request.getRequestURI().toLowerCase();
        path = path.replaceAll("/servlet", "");

        Command command = commandMap.getOrDefault(path, (r) -> "/index.jsp");

        String page = command.execute(request);

        if (page.contains("redirect: ")) {
            page = page.replaceAll("redirect: ", "");
            String redirect = request.getContextPath() + "/servlet" + page;

            response.sendRedirect(redirect);


        } else {
            request.getRequestDispatcher(page).forward(request, response);

        }
    }
}