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
		src="./images/truyum-logo-light.png" /> <a id="menu"
		href="ShowMenuItemListAdmin">Menu</a> </header>
	<div class="cont">
		<form>
			<table>
				<tr>
					<td><h1>Edit Menu Item Status</h1></td>
				</tr>
				<tr>
					<td><h3>
							<p id="para">${msg }</p>
						</h3></td>
				</tr>
			</table>
		</form>
	</div>
	<footer> <span> Copyright@2019 </span> </footer>
</body>
</html>