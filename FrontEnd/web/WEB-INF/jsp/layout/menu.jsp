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
<c:if  test="${userBean != null}">
      <a class="navbar-brand" href="index">Home</a>
</c:if>
<c:choose>
    <c:when test="${userBean == null}">
        <a class="navbar-brand" href="session">Login</a>
    </c:when>
    <c:otherwise>
        <a class="navbar-brand" href="session?logout">Logout</a>
    </c:otherwise>
</c:choose>

<c:if  test="${userBean != null}">
    <a class="navbar-brand" href="client">Clients</a>
</c:if>
    <a class="navbar-brand" href="item">Inventory</a>
    <a class="navbar-brand" href="">Shipping</a>

    </div>
  </div>
</nav>

<div class="container">

<c:if test="${notifications != null}">
  <div id="notifications">
    <ul>
      <c:forEach items="${notifications}" var="item">
        <li class="${item.type}">${item.notification}</li>
      </c:forEach>
    </ul>
  </div>
</c:if>
