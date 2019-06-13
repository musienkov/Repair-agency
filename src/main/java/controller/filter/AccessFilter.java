package controller.filter;

import javax.servlet.annotation.WebFilter;
import model.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@WebFilter(filterName = "AccessFilter")

public class AccessFilter implements   Filter {
    Map<String, List> accessMap = new HashMap<>();
    List<String> userRoleAllowed = new ArrayList<>();
    List<String> managerRoleAllowed = new ArrayList<>();
    List<String> masterRoleAllowed = new ArrayList<>();
    List<String> unknownRoleAllowed = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        userRoleAllowed.add("/index");
        userRoleAllowed.add("/user");

        userRoleAllowed.add("/logout");
        userRoleAllowed.add("/neworder");
        userRoleAllowed.add("/gotoneworder");
        userRoleAllowed.add("/gotocompletedorders");
        userRoleAllowed.add("/gotoacceptedorders");
        userRoleAllowed.add("/gotorefusedorders");
        userRoleAllowed.add("/gotoleavefeedback");
        userRoleAllowed.add("/leavefeedback");



        managerRoleAllowed.add("/index");
        managerRoleAllowed.add("/manager");

        managerRoleAllowed.add("/logout");
        managerRoleAllowed.add("/gotoseeorders");
        managerRoleAllowed.add("/acceptorder");
        managerRoleAllowed.add("/gotoacceptorder");
        managerRoleAllowed.add("/gotorefuseorder");
        managerRoleAllowed.add("/refuseorder");


        masterRoleAllowed.add("/logout");
        masterRoleAllowed.add("/index");
        masterRoleAllowed.add("/master");
        masterRoleAllowed.add("/gotoorders");
        masterRoleAllowed.add("/makeorder");
        masterRoleAllowed.add("/gotomakeorder");
        masterRoleAllowed.add("/gotofeedback");
        masterRoleAllowed.add("/gotohistory");




        unknownRoleAllowed.add("/toregistr");
        unknownRoleAllowed.add("/registration");
        unknownRoleAllowed.add("/login");
        unknownRoleAllowed.add("/index");

        unknownRoleAllowed.add("/logout");

        accessMap.put("USER", userRoleAllowed);
        accessMap.put("MANAGER", managerRoleAllowed);
        accessMap.put("UNKNOWN", unknownRoleAllowed);
        accessMap.put("MASTER", masterRoleAllowed);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;

        User user = (User) request.getSession().getAttribute("user");

        if(user != null) {
            String role = user.getRole();
            List<String> commandList = accessMap.get(role);
            String path = request.getRequestURI().toLowerCase().replaceAll("/servlet", "").trim();
            if (commandList.contains(path)) {

                filterChain.doFilter(request, response);
            }
            else {

                //todo
            }
        }
        else {

            List<String> commandList1 = accessMap.getOrDefault("UNKNOWN", unknownRoleAllowed);
            String path = request.getRequestURI().toLowerCase().replaceAll("/servlet", "").trim();
            if (commandList1.contains(path)) {
                filterChain.doFilter(request, response);
            }
            else {

              //todo
            }
        }
    }

    @Override
    public void destroy() {

    }
}
