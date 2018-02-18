<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Popup JSP</title>
</head>
<body>
	<input type="button" value="Click Message" onclick="javascript:showMessage();"/>
	<%
		String message = (String)request.getParameter("message");		
	%>
	<h3 style="color:blue">The message is:<%=message%></h3>	
</body>
<script type="text/javascript">
	function showMessage() {
		alert("child popup");
		var m = "<%=message%>";
		alert(m);	
	}
	</script>
</html>