
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 04.03.2019
  Time: 21:34
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


    <title>Simple Sidebar - Start Bootstrap Template</title>

    <!-- Bootstrap core CSS -->
    <link href="/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/css/simple-sidebar.css" rel="stylesheet">

</head>

<body>

<div class="d-flex" id="wrapper">



    <!-- Page Content -->
    <div id="page-content-wrapper">

        <nav class="navbar navbar-expand-lg border-bottom">
            <!--  <button class="btn btn-primary" id="menu-toggle">Toggle Menu</button> -->

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ml-auto mt-2 mt-lg-0">

                    <li class="nav-item">
                        <a class="nav-link" href="index"><fmt:message key="registration"/></a>
                    </li>

                    </li>
                </ul>
            </div>
        </nav>

        <div class="container-fluid">
            <div class="row">
                <div class="col-3">
                </div>
                <div class="col-6">
                    <div class="title-login" align="center">
                        <h2><fmt:message key="welcome"/></h2>

                    </div>
                    <form action="${pageContext.request.contextPath}/servlet/registration" method="post" align="center">

                        <div class="form-group">
                            <label for="name"><fmt:message key="INPUT_NAME"/> </label>
                            <input type="text" class="form-control" id="name" name="name">
                        </div>

                        <div class="form-group">
                            <label for="login"><fmt:message key="INPUT_LOGIN"/> </label>
                            <input type="login" class="form-control" id="login" name="login">
                        </div>

                        <div class="form-group">
                            <label for="pass"><fmt:message key="INPUT_PASSWORD"/> </label>
                            <input type="password" class="form-control" id="pass" name="pass">
                        </div>

                        <div class="form-group">
                            <label for="confirm"><fmt:message key="page.reg.confirm_pass"/> </label>
                            <input type="password" class="form-control" id="confirm" name="confirm">
                        </div>

                        <button type="submit" class="btn btn-primary"><fmt:message key="registration"/> </button>

                    </form>
                </div>

                <div class="col-sm-1">

                </div>
            </div>
        </div>
    </div>
</div>
<!-- /#page-content-wrapper -->

</div>
<!-- /#wrapper -->

<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Menu Toggle Script -->
<script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
</script>

</body>

</html>

