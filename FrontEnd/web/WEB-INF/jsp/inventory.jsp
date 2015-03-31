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

<h3 style="margin-top: 40px;">Trees</h3>
<table style="width:100%">
  <tr class="table-title">
    <td>Product Id:</td>
    <td>Description:</td>
    <td>Price:</td>
    <td>Quantity:</td>
  </tr>
  <tr>
    <td><a href="url">1</a></td>
    <td>Carvalho</td>
    <td>35</td>
    <td>42</td>
  </tr>
  <tr>
    <td><a href="url">2</a></td>
    <td>Cidreira</td>
    <td>656</td>
    <td>65</td>
  </tr>
</table>
<h3>Seeds</h3>
<table style="width:100%">
  <tr class="table-title">
    <td>Product Id:</td>
    <td>Description:</td>
    <td>Price:</td>
    <td>Quantity:</td>
  </tr>
  <tr>
    <td><a href="url">3</a></td>
    <td>Batata</td>
    <td>35</td>
    <td>44</td>
  </tr>
  <tr>
    <td><a href="url">4</a></td>
    <td>Morango</td>
    <td>33</td>
    <td>32</td>
  </tr>
</table>
<h3>Shrubs</h3>
<table style="width:100%">
  <tr class="table-title">
    <td>Product Id:</td>
    <td>Description:</td>
    <td>Price:</td>
    <td>Quantity:</td>
  </tr>
  <tr>
    <td><a href="url">5</a></td>
    <td>Acucar</td>
    <td>32</td>
    <td>232</td>
  </tr>
  <tr>
    <td><a href="url">6</a></td>
    <td>Leak</td>
    <td>12</td>
    <td>32</td>
  </tr>
</table>
<a href="item?add" class="btn btn-lg btn-primary btn-block" style="width:150px; float:right; margin-top:50px;">New Item</a>

<jsp:include page="layout/footer.jsp" />
