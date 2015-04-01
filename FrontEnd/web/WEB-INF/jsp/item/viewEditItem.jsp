<%--
  Created by IntelliJ IDEA.
  User: Jaime
  Date: 31/03/2015
  Time: 09:47
  To change this template use File | Settings | File Templates.
--%>

<jsp:include page="../layout/top.jsp" />
<jsp:include page="../layout/menu.jsp" />
<h2 style="margin-top: 40px;">Edit Item</h2>

<form action="item" method="post" class="form" role="form">
  <h3 style="margin-top: 40px;">Tree</h3>
  <table style="width:30%; margin-top: 20px;">
    <tr>
      <td>Product ID:</td>
      <td style="padding-left:10px;">
        ${itemBean.id}
        <input type="hidden" name="id" value="${itemBean.id}">
      </td>
    </tr>
    <tr>
      <td>Description:</td>
      <td><input type="text" class="form-control" name="desc" style="width: 170px" value="${itemBean.description}"></td>
    </tr>
    <tr>
      <td>Price:</td>
      <td>
        <input type="number" class="form-control" name="price" step="0.01" min="0" style="width: 170px" value="${itemBean.price}">
      </td>
    </tr>
    <tr>
      <td>Quantity:</td>
      <td><input type="number" class="form-control" name="quantity" min="0" style="width: 170px" value="${itemBean.stock}"></td>
    </tr>
  </table>
  <button type="submit" class="btn btn-lg btn-primary btn-block" name="edit" style="width:100px; margin-top:30px;">Save</button>
</form>
<!--<a href="listItems.html" class="btn btn-lg btn-primary btn-block" style="width:150px; float:right; margin-top:20px;">Cancel</a>  -->

<jsp:include page="../layout/footer.jsp" />
