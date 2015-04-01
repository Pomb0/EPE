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

<h2 style="margin-top: 40px;">New Client</h2>
<form action="client?add" method="post" class="form" role="form">
  <table style="width:50%; margin-top: 20px;">
    <tr>
      <td>Customer First Name:</td>
      <td><input type="text" class="form-control" name="firstName" style="width: 250px"></td>
    </tr>
    <tr>
      <td>Customer Last Name:</td>
      <td><input type="text" class="form-control" name="lastName" style="width: 250px"></td>
    </tr>
    <tr>
      <td>Customer Address:</td>
      <td><input type="text" class="form-control" name="address" style="width: 250px"></td>
    </tr>
    <tr>
      <td>Customer phone number:</td>
      <td><input type="tel" class="form-control" name="phone" style="width: 250px"></td>
    </tr>
  </table>
  <button type="submit" class="btn btn-lg btn-primary btn-block" name="save" style="width:100px; margin-top:30px;">Save</button>
</form>

<jsp:include page="../layout/footer.jsp" />