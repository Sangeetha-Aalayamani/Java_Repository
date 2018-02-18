<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Popup JSP</title>
</head>
<body>
	<input type="button" value="Alert Message" onclick="javascript:openChildPopup();"/>
	<%
		String message = (String)request.getParameter("message");
	%>
	<h3 style="color:blue">The message is:<%=message%></h3>
	
	<script type="text/javascript">
		function openChildPopup() {		
			var winpop = window.open("<%=request.getContextPath()%>/pages/childPopup.jsp?&message=<%=message%>","newwindow","height=250,width=400,status=no,location=no,toolbar=no,directories=no,menubar=no");
		}
	</script>
</body>
</html>