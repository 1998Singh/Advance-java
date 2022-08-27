<%@page import="modal.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Details</title>
<!-- <button style="margin-left: 400px; margin-top: 50px" onclick="location.href ='/employee-registration/login'" >Return</button> -->
<style>
table, tr {
	border: 1px solid black;
}
</style>
</head>
<body>
	<h1 align="center">Employee Details</h1>
	<%
	Employee empDetails = (Employee) request.getAttribute("empData");
	%>
	<table align="center">
		<tr>
			<th>Emp ID:</th>
			<td><input type="number" name="empid" readonly="readonly"
				value="<%=empDetails.getEmpid()%>" /></td>
		</tr>

		<tr>
			<th>Name:</th>
			<td><input type="text" name="name" readonly="readonly"
				value="<%=empDetails.getName()%>" /></td>
		</tr>

		<tr>
			<th>Email ID:</th>
			<td><input type="text" name="email" readonly="readonly"
				value="<%=empDetails.getEmail()%>" /></td>
		</tr>

		<tr>
			<th>Address ID:</th>
			<td><input type="number" name="addid" readonly="readonly"
				value="<%=empDetails.getAddress().getAddid()%>" /></td>
		</tr>

		<tr>
			<th>Contact:</th>
			<td><input type="text" name="contact" readonly="readonly"
				value="<%=empDetails.getAddress().getContact()%>" /></td>
		</tr>

		<tr>
			<th>City:</th>
			<td><input type="text" name="city" readonly="readonly"
				value="<%=empDetails.getAddress().getCity()%>" /></td>
		</tr>

		<tr>
			<th>State:</th>
			<td><input type="text" name="state" readonly="readonly"
				value="<%=empDetails.getAddress().getState()%>" /></td>
		</tr>

		<tr>
			<th>Zip:</th>
			<td><input type="text" name="zip" readonly="readonly"
				value="<%=empDetails.getAddress().getZip()%>" /></td>
		</tr>

		</form>
</body>
</html>