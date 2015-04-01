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

<h2 style="margin-top: 40px;">Customer Page</h2>
<table style="width:100%; margin-top: 20px;">
  <tr class="table-title">
    <td>Id</td>
    <td>Costumer First Name:</td>
    <td>Costumer Last Name:</td>
    <td>Phone Number:</td>
  </tr>
  <tr>
    <td>${client.id}</td>
    <td>${client.firstName}</td>
    <td>${client.lastName}</td>
    <td>${client.phoneNumber}</td>
  </tr>
</table>
<br>
<table style="width:100%; margin-top: 20px;">
  <tr class="table-title">
    <td>Mailing Address:</td>
  </tr>
  <tr>
    <td>${client.address}</td>
  </tr>
</table>
<br>
<a class="btn btn-lg btn-primary btn-block" name="new" style="width:150px; margin-top:30px;" href="order?buyerId=${client.id}">New Order</a>


<jsp:include page="../layout/footer.jsp" />
