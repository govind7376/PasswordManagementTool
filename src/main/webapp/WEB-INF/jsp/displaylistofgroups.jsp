<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>AllGroups</h2>
<table border=1>
<tr>
<th>GroupName</th>
</tr>
<c:forEach items="${groups}" var="group">
<tr>
<td><c:out   value= "${group.groupName}"></c:out></td>
</tr>
</c:forEach>
</table>

<a href="/">Menu</a>

</body>
</html>