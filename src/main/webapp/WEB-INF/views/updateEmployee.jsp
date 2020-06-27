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
	<form action="./updateEmp" method="get">
		Enter Employee ID to change name<input type="number" name="empId"><br>
		Enter Employee New NAme<input type="text" name="empName"> <input
			type="submit" name="submit">
	</form>
	<%
		if (msg != null) {
	%>
	<h3 style="color: green;">
		Employee added for<%=msg%></h3>

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