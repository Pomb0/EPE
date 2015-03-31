<%--
  Created by IntelliJ IDEA.
  User: Jaime
  Date: 31/03/2015
  Time: 01:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="layout/top.jsp" />
<jsp:include page="layout/menu.jsp" />
<div class = "container">
  <br>
  <h2 class="form-signin-heading"><center>Register</center></h2>

  <form action="register" method="post" class="form-signin" role="form">
    <input type="text" class="form-control" placeholder="Username" name="username" required />
    <input type="password" class="form-control" placeholder="Password" name="password" required />
    <input type="password" class="form-control" placeholder="Re-enter Password" name="vpassword" required />
    <button class = "btn btn-lg btn-primary btn-block" type = "submit" value="reg" name = "reg"> Register </button>
  </form>
</div>
<jsp:include page="layout/footer.jsp" />