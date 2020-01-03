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
		href="ShowCart">Cart</a> <a id="menu" href="ShowMenuItemListCustomer">Menu</a>
	</header>

	<div class="cont">
		<h2>Menu Items</h2>

		<table class="table">
			<h3>
				<p id="p">${msg }</p>
			</h3>
			<tr>
				<th class="names">Name</th>
				<th class="cent">Free Delivery</th>
				<th class="price">Price</th>
				<th class="cent">Category</th>
				<th class="cent">Action</th>
			</tr>

			<c:forEach items="${menuItemList }" var="menu">
				<tr>

					<td class="names">${menu.name }</td>

					<td class="cent"><c:if test="${menu.freeDelivery }"> Yes</c:if>
						<c:if test="${!menu.freeDelivery }">No</c:if></td>

					<td class="price">Rs.${menu.price }</td>

					<td class="cent">${menu.category }</td>

					<td class="cent"><a href="AddToCart?menuItemId=${menu.id }"
						target="_blank">Add To Cart</a></td>

				</tr>
			</c:forEach>

		</table>
	</div>
	<footer> <span> Copyright@2019 </span> </footer>
</body>
</html>
