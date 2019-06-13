<!DOCTYPE html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<c:if test="${lang==null}">

  <fmt:setBundle basename="strings" var="lang" scope="session"/>
</c:if>

<c:if test="${param.get('lang').equals('UA')}">

  <fmt:setLocale value="ua" scope="session"/>
  <fmt:setBundle basename="strings"
                 var="lang" scope="session"/>

</c:if>

<html>

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">

  <meta name="author" content="">


  <title>Repair agency</title>

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
            <a class="nav-link" href="${pageContext.request.contextPath}/servlet/toregistr"><fmt:message key="registration" bundle="${lang}"/></a>
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



          <div class="title-login"  align="center">
            <h2> <fmt:message key="LOGIN" bundle="${lang}"/></h2>

          </div>




          <c:if test="${not empty error}">
            <div class="alert alert-danger">
              <strong>Error!</strong> <c:out value="${error}"/>
            </div>
          </c:if>


          <form action="${pageContext.request.contextPath}/servlet/login" method="post" align="center">
            <div class="form-group">
              <label for="login"><fmt:message key="login" bundle="${lang}"/> </label>
              <input type="login" class="form-control" id="login" name="login">
            </div>
            <div class="form-group">
              <label for="pass"><fmt:message key="password" bundle="${lang}"/> </label>
              <input type="password" class="form-control" id="pass" name="pass">
            </div>

            <button type="submit" class="btn btn-primary"><fmt:message key="loginLable" bundle="${lang}"/> </button>

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
