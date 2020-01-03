<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Menu List</title>
<link rel="stylesheet" type="text/css" href="./style/style.css" />
<script src="./js/script.js" type="text/javascript"></script>
</head>
<body>
	<header> <span> truYum </span> <img class="img"
		src="./images/truyum-logo-light.png" /> <a id="menu"
		href="ShowMenuItemListAdmin">Menu</a> </header>
	<div class="cont">
		<h2>Edit Menu Item</h2>
		<form name="menuform" method="post"
			action="EditMenuItem?menuItemId=${menuItem.id }"
			onSubmit="return validation()">
			<table>
				<tr>
					<td colspan="4">Name</td>
				</tr>
				<tr>
					<td colspan="4"><input type="text" id="name" name="txtName"
						value="${menuItem.name }" size="80" /></td>
				</tr>
				<tr>
					<td>Price(Rs.)</td>
					<td>Active</td>
					<td>Date of Launch</td>

					<td>Category</td>
				</tr>
				<tr>
					<td><input class="price" type="text" id="price"
						name="txtPrice" value="${menuItem.price }" /></td>

					<td><input type="radio" id="rd1" name="active" value="Yes"
						<c:if test="${menuItem.active eq 'true' }">Checked</c:if>>Yes
						<input type="radio" id="rd2" name="active" value="No"
						<c:if test="${menuItem.active eq 'false' }">Checked</c:if>>No
					</td>
					<td><fmt:formatDate type="date" pattern="dd/MM/yyyy"
							value="${menuItem.dateOfLaunch }" var="formatDate" /> <input
						type="text" id="launch" name="launch" value="${formatDate }" /></td>
					<td><select name="category">
							<option value="${menuItem.category }">${menuItem.category }</option>
							<option value="Starters">Starters</option>
							<option value="mc" selected>Main Course</option>
							<option value="desert">Dessert</option>
							<option value="drnk">Drinks</option>
					</select></td>
				</tr>
				<tr>
					<td colspan="2"><input type="checkbox" name="Chbox"
						<c:if test="${menuItem.freeDelivery eq 'true'}">Checked</c:if>
						<c:if test="${menuItem.freeDelivery eq 'false'}"></c:if>>
						<label for="chbox">Free Delivery</label></td>
				</tr>
				<tr>
					<td colspan="2"><input class="btn" type="Submit" name="Submit"
						value="save" onClick="validate" /></td>
				</tr>
			</table>
		</form>
	</div>
	<footer> <span> Copyright@2019 </span> </footer>
</body>
</html>