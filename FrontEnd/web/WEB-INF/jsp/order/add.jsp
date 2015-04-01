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

<h2 style="margin-top: 40px;">New Order</h2>

<form action="order" method="post" class="form" role="form">
  <!--<h3 style="margin-top: 40px;">Trees</h3>-->
  <table style="width:100%">
    <tr class="table-title">
      <td>Product Code:</td>
      <td>Description:</td>
      <td>Price:</td>
      <td>Quantity:</td>
      <td>Order Quantity:</td>
    </tr>
    <c:forEach items="${inventory}" var="item">
      <tr>
        <td><a href="item?id=${item.id}">${item.productCode}</a></td>
        <td>${item.description}</td>
        <td>${item.price}</td>
        <td>${item.stock}</td>
        <input type="hidden" name="productId" value="${item.id}">
        <td><input type="number" class="form-control" name="units" min="0" value="0" style="width:80px;"></td>
      </tr>
    </c:forEach>
  </table>
  <input type="hidden" name="buyerId" value="${buyerId}">
  <button type="submit" class="btn btn-lg btn-primary btn-block" name="save" style="width:100px; margin-top:30px;">Submit</button>
</form>

<jsp:include page="../layout/footer.jsp" />