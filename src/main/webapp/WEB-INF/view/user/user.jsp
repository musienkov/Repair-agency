<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 07.03.2019
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page import="java.util.ResourceBundle" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setBundle basename="strings"/>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">

    <meta name="author" content="">


    <title>User Page</title>

    <!-- Bootstrap core CSS -->
    <link href="/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/css/simple-sidebar.css" rel="stylesheet">

</head>

<body>

<div class="d-flex" id="wrapper">

    <div class="border-right" id="sidebar-wrapper">
        <nav class="navbar navbar-expand-lg navbar-light border-bottom">

            <div class="sidebar-heading">  <a href="${pageContext.request.contextPath}/servlet/user" ><fmt:message key="USER_PAGE"/></a></div>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ml-auto mt-2 mt-lg-0">

                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/servlet/logout"><fmt:message key="LOG_OUT"/></a>
                    </li>

                    </li>
                </ul>
            </div>
        </nav>

        <div class="list-group list-group-flush nav-menu">
            <a href="${pageContext.request.contextPath}/servlet/gotoneworder" class="list-group-item list-group-item-action"><fmt:message key="NEW_ORDER"/></a>
            <a href="${pageContext.request.contextPath}/servlet/gotoacceptedorders" class="list-group-item list-group-item-action"><fmt:message key="ACCEPTED_ORDERS"/></a>
            <a href="${pageContext.request.contextPath}/servlet/gotorefusedorders" class="list-group-item list-group-item-action"><fmt:message key="REFUSED_ORDERS"/></a>
            <a href="${pageContext.request.contextPath}/servlet/gotocompletedorders" class="list-group-item list-group-item-action"><fmt:message key="COMPLETED_ORDERS"/></a>

        </div>
    </div>



    <!-- Page Content -->
    <div id="page-content-wrapper">

        <div class="container-fluid" align="center">
            <h3>  <fmt:message key="USER_INFO"/> </h3>

        </div>
    </div>
</div>

</body>

</html>