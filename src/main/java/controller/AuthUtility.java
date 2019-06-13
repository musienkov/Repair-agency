package controller;

import model.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;

public class AuthUtility {

    static Set<String> loggedUsers;

    public static void setRole(HttpServletRequest request, User user){

        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        session.setAttribute("id", user.getId());
        session.setAttribute("login", user.getLogin());
        session.setAttribute("role", user.getRole());


    }

    public static boolean isLogged(HttpServletRequest request, String login) {
        loggedUsers = getLoggedUsers(request);
        return loggedUsers.stream().anyMatch(login::equals);
    }

    private static Set<String> getLoggedUsers(HttpServletRequest request){
        return (HashSet<String>) request.getSession().getServletContext()
                .getAttribute("loggedUsers");

    }

    private static void setLoggedUsers(HttpServletRequest request, Set<String> loggedUsers){
        request.getSession().getServletContext().setAttribute("loggedUsers", loggedUsers);


    }

    public static String login(HttpServletRequest request, User user){
        loggedUsers = getLoggedUsers(request);
        request.getSession().setAttribute("login", user.getLogin());
        loggedUsers.add(user.getLogin());
        setRole(request, user);
        setLoggedUsers(request, loggedUsers);

        return user.getRole();
    }

    public static void logout(HttpServletRequest request, String  login) {

       loggedUsers = getLoggedUsers(request);
        loggedUsers.remove(login);
        HttpSession session = request.getSession();
        session.invalidate();
        setLoggedUsers(request, loggedUsers);

    }
}
