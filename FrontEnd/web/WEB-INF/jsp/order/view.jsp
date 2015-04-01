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

<h2 style="margin-top: 40px;">Order Details</h2>
<table style="width:100%; margin-top: 20px;">
  <tr class="table-title">
    <td>Id:</td>
    <td>Costumer First Name:</td>
    <td>Costumer Last Name:</td>
    <td>Phone Number:</td>
    <td>Order Date:</td>
    <td>Shipping Date:</td>
  </tr>

  <tr>
    <td><a href="client?id=${order.client.id}">${order.client.id}</a></td>
    <td>${order.client.firstName}</td>
    <td>${order.client.lastName}</td>
    <td>${order.client.phoneNumber}</td>
    <td>${order.dateOrder}</td>
    <td>${order.dateShipped}</td>
  </tr>
</table>
<br>
<table style="width:100%; margin-top: 20px;">
  <tr class="table-title">
    <td>Mailing Address:</td>
  </tr>
  <tr>
    <td>${order.client.address}</td>
  </tr>
</table>
<br>
<h3>Order Items</h3>


<table style="width:50%; margin-top: 20px;">
  <tr class="table-title">
    <td>Product Id:</td>
    <td>Product code:</td>
    <td>Product Type:</td>
    <td>Description:</td>
    <td>Price:</td>
    <td>Quantity:</td>
  </tr>

  <c:forEach items="${order.itemList}" var="item">
    <tr>
      <td><a href="item?id=${item.id}">${item.id}</a></td>
      <td>${item.productCode}</td>
      <td>${item.plantType.type}</td>
      <td>${item.description}</td>
      <td>${item.price}</td>
      <td>1</td>
    </tr>
  </c:forEach>

</table>

<c:if  test="${!order.shipped}">
  <a type="submit" href="shipping?ship=${order.id}" class="btn btn-lg btn-primary btn-block" name="ship" style="width:100px; margin-top:30px;">Ship</a>
</c:if>


<jsp:include page="../layout/footer.jsp" />
