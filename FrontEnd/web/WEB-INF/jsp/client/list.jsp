<%--
  Created by IntelliJ IDEA.
  User: Jaime
  Date: 01/04/2015
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../layout/top.jsp" />
<jsp:include page="../layout/menu.jsp" />


<h2 style="margin-top: 40px;">Clients</h2>
<table style="width:100%; margin-top: 20px;">
  <tr class="table-title">
    <td>Costumer Id:</td>
    <td>Costumer First Name:</td>
    <td>Costumer Last Name:</td>
    <td>Phone Number:</td>
    <td>Address:</td>
  </tr>

<c:forEach items="${clientList}" var="item">
  <tr>
    <td><a href="client?id=${item.id}">${item.id}</a></td>
    <td>${item.firstName}</td>
    <td>${item.lastName}</td>
    <td>${item.phoneNumber}</td>
    <td>${item.address}</td>
  </tr>
</c:forEach>
</table>
<a href="client?add" class="btn btn-lg btn-primary btn-block" style="width:150px; margin-top:50px;">New Client</a>

<jsp:include page="../layout/footer.jsp" />