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


<h2 style="margin-top: 40px;">Pending Orders</h2>
<table style="width:70%; margin-top: 20px;">
  <tr class="table-title">
    <td>Order Number:</td>
    <td>Order Date and Time:</td>
    <td>Costumer Name:</td>
  </tr>
<c:forEach items="${pendingOrders}" var="item">
  <tr>
    <td><a href="shipping?id=${item.id}">${item.id}</a></td>
    <td>${item.dateOrder}</td>
    <td>${item.client.firstName} ${item.client.lastName}</td>
  </tr>
</c:forEach>
</table>


<h2 style="margin-top: 40px;">Shipped Orders</h2>
<table style="width:70%; margin-top: 20px;">
  <tr class="table-title">
    <td>Order Number:</td>
    <td>Order Date and Time:</td>
    <td>Costumer Name:</td>
  </tr>
  <c:forEach items="${shippedOrders}" var="item">
    <tr>
      <td><a href="shipping?id=${item.id}">${item.id}</a></td>
      <td>${item.dateOrder}</td>
      <td>${item.client.firstName} ${item.client.lastName}</td>
    </tr>
  </c:forEach>
</table>





<jsp:include page="../layout/footer.jsp" />