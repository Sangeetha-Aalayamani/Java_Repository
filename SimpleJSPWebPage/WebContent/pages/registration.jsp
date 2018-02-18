<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
div.container {
	text-align: right width:300px;
	padding: 10px;
	border: 5px solid turquoise;
	margin: 0px;
	font-weight: normal;
}
</style>
<title>Registration Form</title>
</head>
<body>
	<div class="container">
		<form action="RegistrationController" method="POST" id="myForm">
			<table style="width:50%">
				<tr>
					<td>FirstName: </td>
					<td><input type="text" name="firstName"/> </td>
				</tr>
				<tr>
					<td>LastName: </td>
					<td><input type="text" name="lastName"/> </td>
				</tr>
				<tr>
					<td>Age: </td>
					<td><input type="text" name="age"/> </td>
				</tr>
				<tr>
					<td>Qualification: </td>
					<td><input type="text" name="qualification"/> </td>
				</tr>
				<tr>
					<td>Percentage: </td>
					<td><input type="text" name="percentage"/> </td>
				</tr>
				
			</table>
			<input type="submit" value="Register"/>
			<input type="hidden" name="message" value="Shalom"/>
		</form>
	</div>
	
</body>
</html>