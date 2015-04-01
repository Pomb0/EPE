<%--
  Created by IntelliJ IDEA.
  User: Jaime
  Date: 31/03/2015
  Time: 09:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="layout/top.jsp" />
<jsp:include page="layout/menu.jsp" />

<h2 style="margin-top: 40px;">Inventory</h2>

<!--<h3 style="margin-top: 40px;">Trees</h3>-->

<table style="width:100%">
  <tr class="table-title">
    <td>Product Id:</td>
    <td>Product Code:</td>
    <td>Description:</td>
    <td>Price:</td>
    <td>Quantity:</td>
  </tr>
<c:forEach items="${inventory}" var="item">
  <tr>
    <td><a href="item?id=${item.id}">${item.id}</a></td>
    <td><a href="item?id=${item.id}">${item.productCode}</a></td>
    <td>${item.description}</td>
    <td>${item.price}</td>
    <td>${item.stock}</td>
  </tr>
</c:forEach>
</table>

<a href="item?add" class="btn btn-lg btn-primary btn-block" style="width:150px; float:right; margin-top:50px;">New Item</a>

<jsp:include page="layout/footer.jsp" />
