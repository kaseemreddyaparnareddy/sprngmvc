<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String msg = (String) request.getAttribute("msg");
	String errMsg = (String) request.getAttribute("errMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="./deleteEmp" method="get">
		Employee Id to be deleted: <input type="number" name="empId"><br>
		<input type="submit">

	</form>
	<%
		if (msg != null) {
	%>
	<h3 style="color: green;"><%=msg%></h3>

	<%
		}
	%>
	<%
		if (errMsg != null && !errMsg.isEmpty()) {
	%>
	<h2 style="color: red;"><%=errMsg%></h2>
	<%
		}
	%>
</body>
</html>