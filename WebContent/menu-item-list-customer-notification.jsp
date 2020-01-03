<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
>
<html>
<head>
<title>Menu List</title>
<link rel="stylesheet" type="text/css" href="./style/style.css" />
</head>
<body>
	<header> <span> truYum </span> <img class="img"
		src="./images/truyum-logo-light.png"/ > <a id="menu"
		href="cart.html">Cart</a> <a id="menu"
		href="menu-item-list-customer.html">Menu</a> </header>

	<div class="cont">
		<h2>Menu Items</h2>
		<table class="table">
			<tr>
				<p id="p">
				<h3>Items Added to The Cart Successfully</h3>
				</p>
			</tr>
			<tr>
				<th class="names">Name</th>
				<th class="cent">Free Delivery</th>
				<th class="price">Price</th>
				<th class="cent">Category</th>
				<th class="cent">Action</th>
			</tr>
			
			<c:forEach items="${menuItemListCustomer }" var="menu">
				<tr>

					<td class="names">${menu.name }</td>

					<td class="cent"><c:if test="${menu.freeDelivery }"> Yes</c:if>
						<c:if test="${!menu.freeDelivery }">No</c:if></td>

					<td class="price">Rs.${menu.price }</td>

					<td class="cent">${menu.category }</td>



					<td class="cent"><a href="AddToCart">Add to Cart</a></td>

				</tr>
			</c:forEach>

		</table>
	</div>
	<footer> <span> Copyright@2019 </span> </footer>
</body>
</html>
