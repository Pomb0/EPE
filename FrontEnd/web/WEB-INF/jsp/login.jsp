<%--
  Created by IntelliJ IDEA.
  User: Jaime
  Date: 31/03/2015
  Time: 06:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="layout/top.jsp" />
<jsp:include page="layout/menu.jsp" />

<center> <h2 class="form-signin-heading"> Please sign in </h2> </center>

<form action="session" method="post" class="form-signin" role="form">
  <input type="text" class="form-control" placeholder="Username" name="username" required />
  <input type="password" class="form-control" placeholder="Password" name="password" required />
  <button class = "btn btn-lg btn-primary btn-block" type = "submit" value="log" name = "log"> Sign in </button>
  <a class = "btn btn-lg btn-primary btn-block" type = "submit" value="reg" name = "reg"> Register </a>
</form>

<jsp:include page="layout/footer.jsp" />
