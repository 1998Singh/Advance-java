<%@page import="java.lang.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Registration Form</title>
<style>
table, tr {
	border: 1px solid black;
}
</style>
</head>
<body>
<%
	String str = (String) request.getAttribute("msg");
	%>
	<h1 align="center">Login Page</h1>
	<form action="login" method="post">

		<table align="center">
			<tr>
				<th>userName:</th>
				<td><input type="text" name="userName" /></td>
			</tr>

			<tr>
				<th>password:</th>
				<td><input type="password" name="password" /></td>
			</tr>
		</table>
		<p align="center" />
		<input type="submit" value="login" />

	</form>
	<h3 align="center" style="color: red">
		<%
		if (str != null && str.length() > 0) {
			out.print(str);
		}
		%>
	</h3>


</body>
</html>