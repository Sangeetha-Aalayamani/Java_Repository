<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table#container{
	width: 50%;
	background-color:Gainsboro;
	border: 5px solid turquoise;
}
</style>
<script>
function goBack() {
    window.history.back();
    window.location.reload();
}

</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome User</title>
</head>
<body>
<%
	String firstName = request.getParameter("firstName");
	String lastName = request.getParameter("lastName");
	String age = request.getParameter("age");
	String qualification = request.getParameter("qualification");
	String percentage = request.getParameter("percentage");
%>
</body>
	<table id="container">
		<tr>
			<td>FirstName</td>
			<td><%=firstName %>
		</tr>
		<tr>
			<td>LastName</td>
			<td><%=lastName %>
		</tr>
		<tr>
			<td>Age</td>
			<td><%=age %>
		</tr>
		<tr>
			<td>Qualification</td>
			<td><%=qualification %>
		</tr>
		<tr>
			<td>Percentage</td>
			<td><%=percentage %>
		</tr>		
	</table>
	<input type="submit" value="Back to Home" onclick="goBack();"> 
	
	<input type="button" value="OpenPopup" onclick="javascript:openPopup();"/>
	<%
		String message = request.getParameter("message"); 
	%>

	<input type="hidden" name="message" value="<%=message%>"/>
	<script type="text/javascript">
		function openPopup() {		
			var winpop = window.open("<%=request.getContextPath()%>/pages/popup.jsp?&message=<%=message%>","Test Popup","height=250,width=400,status=no,location=no,toolbar=no,directories=no,menubar=no");
		}
	</script>
	</body>
</html>