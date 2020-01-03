<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
		<h2>Cart</h2>
		<table class="table" colspan="4">
			<p id="p">"${msg }"</p>

			<tr>
				<th class="names">Name</th>
				<th class="names">Free Delivery</th>
				<th class="price">Price</th>
				<th class="cent"></th>
			</tr>

			<c:forEach items="${menuItemListCustomer }" var="menu">
				<tr>

					<td class="names"><c:out value="${menu.name }"></c:out></td>
					<td class="cent"><c:out
							value="${menu.freeDelivery ?'Yes':'No' }"></c:out></td>

					<td class="price"><c:out value="Rs.${menu.price }"></c:out></td>
					<td class="cent"><a href="RemoveCart?menuItemId=${menu.id }">Delete</a></td>
				</tr>
			</c:forEach>

			<tr>
				<th></th>
				<th class="names">Total</th>
				<th class="price">Rs.${Total }</th>
			</tr>

		</table>
	</div>
	<footer> <span> Copyright@2019 </span> </footer>
</body>
</html>
