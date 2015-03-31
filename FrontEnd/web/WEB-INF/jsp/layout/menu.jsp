<%--
  Created by IntelliJ IDEA.
  User: Jaime
  Date: 31/03/2015
  Time: 02:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-fixed-top navbar-inverse" role="navigation">
  <div class="container">
    <div class="navbar-header">
      <a class="navbar-brand" href="login.html" style="Margin-top:7px;"> Login </a>
      <a class="navbar-brand" href="shipping.html" style="Margin-top:7px;"> Shipping </a>
      <a class="navbar-brand" href="orders.html" style="Margin-top:7px;"> Orders </a>
      <a class="navbar-brand" href="inventory.html" style="Margin-top:7px;"> Inventory </a>
    </div>
  </div>
</nav>

<c:if test="${notifications != null}">
  <div id="notifications">
    <ul>
      <c:forEach items="${notifications}" var="item">
        <li class="${item.type}">${item.notification}</li>
      </c:forEach>
    </ul>
  </div>
</c:if>