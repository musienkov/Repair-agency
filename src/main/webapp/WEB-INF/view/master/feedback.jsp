<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 10.03.2019
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page import="java.util.ResourceBundle" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setBundle basename="strings"/>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">

    <meta name="author" content="">


    <title>Feedback</title>

    <!-- Bootstrap core CSS -->
    <link href="/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/css/simple-sidebar.css" rel="stylesheet">

</head>

<body>

<div class="d-flex" id="wrapper">

    <!-- Sidebar -->
    <div class="border-right" id="sidebar-wrapper">
        <nav class="navbar navbar-expand-lg border-bottom">

            <div class="sidebar-heading"><a href="${pageContext.request.contextPath}/servlet/master" ><fmt:message key="MASTER_PAGE"/></a></div>


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
            <a href="${pageContext.request.contextPath}/servlet/gotoorders" class="list-group-item list-group-item-action"><fmt:message key="ORDERS"/></a>
            <a href="${pageContext.request.contextPath}/servlet/gotofeedback" class="list-group-item list-group-item-action"><fmt:message key="FEEDBACK"/></a>
            <a href="${pageContext.request.contextPath}/servlet/gotohistory" class="list-group-item list-group-item-action"><fmt:message key="HISTORY"/></a>

        </div>
    </div>


    <!-- Page Content -->
    <div id="page-content-wrapper">



        <div class="container-fluid">


            <c:if test="${fn:length(feedbackList) eq 0}">
                <div class=>
                    <h2> <fmt:message key="EMPTY"/></h2>
                </div>
            </c:if>

            <c:if test="${fn:length(feedbackList) gt 0}">
                <table class="table table-striped">
                    <thead>
                    <tr>

                        <th><fmt:message key="USER_ID"/> </th>
                        <th><fmt:message key="ORDER_ID"/> </th>
                        <th><fmt:message key="FEEDBACK"/> </th>


                    </tr>

                    </thead>


                    <tbody>

                    <c:forEach var="i" items="${feedbackList}" varStatus="status">

                        <tr>
                            <th>${i.getCustomerId()}</th>
                            <th>${i.order_id}</th>
                            <th>${i.description}</th>



                        </tr>
                    </c:forEach>
                    </tbody>
                </table>



            </c:if>



        </div>
    </div>
</div>

</body>

</html>
